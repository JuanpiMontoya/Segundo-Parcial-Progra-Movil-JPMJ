package com.calyrsoft.ucbp1.features.movie.data.mapper

import com.calyrsoft.ucbp1.features.movie.data.database.entity.MovieEntity
import com.calyrsoft.ucbp1.features.movie.domain.model.MovieModel

fun MovieModel.toEntity(page: Int = 1): MovieEntity {
    return MovieEntity(
        id = id,
        title = title,
        imageUrl = imageUrl,
        page = page,
        timestamp = System.currentTimeMillis()
    )
}