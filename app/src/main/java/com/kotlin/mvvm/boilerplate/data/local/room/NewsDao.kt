package com.kotlin.mvvm.boilerplate.data.local.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import io.reactivex.Maybe

/**
 * Created by cuongpm on 12/1/18.
 */

@Dao
interface NewsDao {

    @Query("SELECT * FROM News ORDER BY time ASC")
    fun getAllNews(): Maybe<List<NewsEntity>>

    @Query("SELECT * FROM News WHERE id = :newsId")
    fun getNewsById(newsId: Int): Flowable<NewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: NewsEntity)
}