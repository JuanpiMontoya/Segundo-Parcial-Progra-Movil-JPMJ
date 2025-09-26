package com.calyrsoft.ucbp1.features.movie.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.calyrsoft.ucbp1.features.movie.data.database.entity.MovieEntity

@Dao
interface IMovieDao {
    @Query("SELECT * FROM movies WHERE page = :page ORDER BY timestamp DESC")
    suspend fun getMoviesByPage(page: Int): List<MovieEntity>

    @Query("SELECT * FROM movies ORDER BY timestamp DESC")
    suspend fun getAllMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Query("DELETE FROM movies WHERE page = :page")
    suspend fun deleteMoviesFromPage(page: Int)

    @Query("DELETE FROM movies")
    suspend fun deleteAllMovies()

    @Query("SELECT COUNT(*) FROM movies WHERE page = :page")
    suspend fun getMoviesCountByPage(page: Int): Int
}
