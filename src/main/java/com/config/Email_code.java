package com.config;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class Email_code {

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
