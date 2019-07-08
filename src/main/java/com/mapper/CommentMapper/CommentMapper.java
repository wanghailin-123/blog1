package com.mapper.CommentMapper;

import com.pojo.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
//    添加评论
    Integer addcomment(Comment comment);
//    通过文章id获取相应的评论
    List<Comment> getCommentById(int tid);
}
