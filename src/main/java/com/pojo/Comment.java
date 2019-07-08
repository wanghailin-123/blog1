package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private String content; //评论内容
    private  int commentid ; //评论id
    private int articleid; //相关联的文章id
    private String comment; //评论的子评论
    private String commentator; //评论人

    public Comment(String content, int articleid, String commentator) {
        this.content = content;
        this.articleid = articleid;
        this.commentator = commentator;
    }
}
