package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private String title;//文章标题
    private String content; //文章内容
    private String author; //作者
    private String type; //文章分类
    private String date; //发表日期
    private int tid; //文章id
    private int readcount; //阅读数量
    private int commentcount; //评论数量

    public Article(String title, String content, String author, String type, String date) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.type = type;
        this.date = date;
    }
}
