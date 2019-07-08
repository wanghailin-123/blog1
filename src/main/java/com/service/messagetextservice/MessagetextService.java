package com.service.messagetextservice;

import com.pojo.messagetext;

import java.util.List;

public interface MessagetextService {
    /**
     * 添加留言
     * @param messagetext
     * @return
     */
    boolean addMessagetext(messagetext messagetext );

    /**
     * 时间升序（最新在后）进行排列留言
     * @return
     */
    List<messagetext> getMessageTextByDateAsc();

    /**
     * 时间降序（最新在前）进行排列留言
     * @return
     */
    List<messagetext> getMessageTextByDateDesc();
}
