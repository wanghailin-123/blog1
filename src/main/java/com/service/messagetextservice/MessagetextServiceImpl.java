package com.service.messagetextservice;

import com.mapper.MessageMapper.MessageMapper;
import com.pojo.messagetext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagetextServiceImpl implements MessagetextService {
    @Autowired
    MessageMapper messageMapper;


    /**
     * 添加留言
     * @param messagetext
     * @return
     */
    @Override
    public boolean addMessagetext(messagetext messagetext) {
        if(messageMapper.addMessagetext(messagetext)>0){
            return true ;
        }else{
            return false;
        }
    }


    /**
     * 时间升序（最新在后）进行排列留言
     * @return
     */
    @Override
    public List<messagetext> getMessageTextByDateAsc() {
        return messageMapper.getMessagetextByDateAsc();

    }



    /**
     * 时间降序（最新在前）进行排列留言
     * @return
     */
    @Override
    public List<messagetext> getMessageTextByDateDesc() {
        return messageMapper.getMessagetextByDateDesc();
    }
}
