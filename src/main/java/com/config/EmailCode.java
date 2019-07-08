package com.config;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

@Component
public class EmailCode {

    /**
     * 发送邮件
     * @param email
     * @return
     */
    public Map sendEmail(String email){
        HashMap<String, Object> map = new HashMap<>();
        String from = "657874997@qq.com";
        String host = "smtp.qq.com";
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session01 = request.getSession();
        String code =  new String(code());
        session01.setAttribute("code",code);
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");
        try {
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("657874997@qq.com","xhgyvxgefcogbfej");
                }
            });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
            message.setSubject("账号登录");
            String content = "<html><head></head><body><h1>这是一封激活邮件,您的激活码是：</h1><h3>"
                    + code +"<br/>"+"有效时间15分钟"+"</h3></body></html>";
            message.setContent(content, "text/html;charset=UTF-8");
            Transport.send(message);
            session01.setAttribute("codeTime",System.currentTimeMillis());
            map.put("codeResult","200");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("codeResult","404");
        }
        return map;
    }

    /**
     * 创建随机数
     * @return
     */
    private StringBuffer code(){
        String sources = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++){
            stringBuffer.append(sources.charAt(random.nextInt(sources.length()))+"");
        }
        return stringBuffer;
    }
}
