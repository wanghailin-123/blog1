package com.service.commentservice;

import com.mapper.CommentMapper.CommentMapper;
import com.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public Integer addCommennt(Comment comment) {
        return commentMapper.addcomment(comment);
    }

    @Override
    public List<Comment> getCommenntById(int id) {

        return commentMapper.getCommentById(id);
    }
}
