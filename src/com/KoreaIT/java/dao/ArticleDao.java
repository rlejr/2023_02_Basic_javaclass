package com.KoreaIT.java.dao;

import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.java.dto.Article;



public class ArticleDao {
	public List<Article> articles;

	public ArticleDao() {
		articles = new ArrayList<>();
	}
}