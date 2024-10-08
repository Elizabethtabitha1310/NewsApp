package com.example.newsapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapp.models.Article


@Dao
interface ArticleDAO {
 @Insert(onConflict = OnConflictStrategy.REPLACE)
 suspend fun upsert(article: Article):Long

 @Query("SELECT*FROM articles")
 fun getAllArticles():LiveData<List<Article>>

 @Delete
 suspend fun  deleteArticles(article: Article)

 @Query("SELECT * FROM articles")
 fun getFavouriteNews(): LiveData<List<Article>>

}