package com.service.articleservice;

import com.mapper.articlemapper.ArticleMapper;
import com.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Integer addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public List<Article> getArticleAll() {
       return  articleMapper.getArticleAll();
    }

    @Override
    public List<Article> getArticleTop3() {
        return articleMapper.getArticleTop3();
    }

    @Override
    public Article getArticleById(int tid) {

        return articleMapper.getArticleById(tid);
    }

    @Override
    public Integer setArticleReadcountById(int id) {

        return articleMapper.setArticleReadcount(id);
    }

    @Override
    public Integer setArticleCommentcountById(int id) {
        return articleMapper.setArticleCommentcount(id);
    }
}

