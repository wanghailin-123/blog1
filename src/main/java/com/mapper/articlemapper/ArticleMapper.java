package com.mapper.articlemapper;


import com.pojo.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {
//    添加文章
    Integer addArticle(Article article);
//    获取全部文章
    List<Article> getArticleAll();
//    获取点击量前三的文章
    List<Article> getArticleTop3();
//    通过文章id获取文章
    Article getArticleById(int tid);
//    设置文章的阅读数量
    Integer setArticleReadcount(int tid);
    //    设置文章的阅读数量
    Integer setArticleCommentcount(int tid);
}
