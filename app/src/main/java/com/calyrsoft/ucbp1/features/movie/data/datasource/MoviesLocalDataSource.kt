package com.calyrsoft.ucbp1.features.movie.data.datasource

import android.util.Log
import com.calyrsoft.ucbp1.features.movie.data.database.dao.IMovieDao
import com.calyrsoft.ucbp1.features.movie.data.database.entity.MovieEntity
import com.calyrsoft.ucbp1.features.movie.domain.model.MovieModel

class MoviesLocalDataSource(
    private val movieDao: IMovieDao
) {
    suspend fun getMoviesByPage(page: Int): List<MovieModel> {
        return movieDao.getMoviesByPage(page).map { it.toModel() }
    }

    suspend fun insertMovies(movies: List<MovieModel>, page: Int) {
        val entities = movies.map { movie ->
            MovieEntity(
                id = movie.id,
                title = movie.title,
                imageUrl = movie.imageUrl,
                page = page
            )
        }
        movieDao.insertMovies(entities)
        Log.d("MoviesLocalDataSource", "Películas insertadas en la base de datos: ${entities.size}")
    }

    suspend fun deleteMoviesFromPage(page: Int) {
        movieDao.deleteMoviesFromPage(page)
    }
}