package com.example.newsapp.repos

import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.database.ArticleDatabase
import com.example.newsapp.models.Article

class NewsRepository (val database: ArticleDatabase){

    suspend fun getHeadlines(countryCode:String,pageNumber:Int) =
        RetrofitInstance.api.getHeadlines(countryCode,pageNumber)

    suspend fun searchNews(searchQuery:String,pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) = database.getArticleDao().upsert(article)

    fun getAllArticles() = database.getArticleDao().getAllArticles()


    suspend fun deleteArticles(article: Article) = database.getArticleDao().deleteArticles(article)
}