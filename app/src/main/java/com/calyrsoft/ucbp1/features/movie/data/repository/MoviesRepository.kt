package com.calyrsoft.ucbp1.features.movie.data.repository
import android.util.Log
import com.calyrsoft.ucbp1.features.movie.data.datasource.MoviesLocalDataSource
import com.calyrsoft.ucbp1.features.movie.data.datasource.MoviesRemoteDataSource
import com.calyrsoft.ucbp1.features.movie.domain.model.MovieModel
import com.calyrsoft.ucbp1.features.movie.domain.repository.IMoviesRepository

private const val TMDB_IMAGE_BASE_W185 = "https://image.tmdb.org/t/p/w185"

class MoviesRepository(
    private val remote: MoviesRemoteDataSource,
    private val local: MoviesLocalDataSource
) : IMoviesRepository {
    override suspend fun getPopular(page: Int): Result<List<MovieModel>> {

        val localMovies = local.getMoviesByPage(page)
        if (localMovies.isNotEmpty()) {
            return Result.success(localMovies)
        }

        val response = remote.getPopularMovies(page)
        return response.fold(
            onSuccess = { pageDto ->
                val dtos = pageDto.results
                val models = dtos.map { dto ->
                    MovieModel(
                        id = dto.id,
                        title = dto.title,
                        imageUrl = dto.backdropPath?.let { "$TMDB_IMAGE_BASE_W185$it" }
                    )
                }

                local.insertMovies(models, page)
                Log.d("MoviesRepository", "Películas guardadas en la base de datos: ${models.size}")
                Result.success(models)
            },
            onFailure = { exception ->
                Result.failure(exception)
            }
        )
    }
}
