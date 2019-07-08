package com.service.articleservice;

import com.pojo.Article;

import java.util.List;

public interface ArticleService {
    /**
     * 发表文章
     * @param article
     * @return
     */
    public Integer addArticle(Article article);

    /**
     * 获取全部文章
     * @return
     */
    public List<Article> getArticleAll();

    /**
     * 获取点击量前三的文章
     * @return
     */
    public List<Article> getArticleTop3();

    /**
     * 通过文章id获取文章
     * @param id
     * @return
     */
    public Article getArticleById(int id);

    /**
     * 通过文章id设置文章的阅读数
     * @param id
     * @return
     */
    public Integer setArticleReadcountById(int id);

    /**
     * 通过文章id设置文章的评论数
     * @param id
     * @return
     */
    public Integer setArticleCommentcountById(int id);
}
