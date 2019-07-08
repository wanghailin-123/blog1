package com.mapper.MessageMapper;
import com.pojo.messagetext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {
//    添加评论
    public Integer addMessagetext(messagetext messagetext );
//    通过时间（最新在后）进行排序；
    List<messagetext> getMessagetextByDateAsc();
//    通过时间（最新在前）进行排序；
    List<messagetext> getMessagetextByDateDesc();
}
