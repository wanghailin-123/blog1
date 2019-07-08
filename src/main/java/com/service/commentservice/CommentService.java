package com.service.commentservice;

import com.pojo.Comment;

import java.util.List;

public interface CommentService {
    Integer addCommennt(Comment comment);
    List<Comment> getCommenntById(int id);
}
