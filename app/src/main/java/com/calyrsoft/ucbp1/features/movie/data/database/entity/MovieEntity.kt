package com.calyrsoft.ucbp1.features.movie.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.calyrsoft.ucbp1.features.movie.domain.model.MovieModel

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "image_url") val imageUrl: String?,
    @ColumnInfo(name = "page") val page: Int = 1,
    @ColumnInfo(name = "timestamp") val timestamp: Long = System.currentTimeMillis()
) {
    fun toModel(): MovieModel {
        return MovieModel(
            id = id,
            title = title,
            imageUrl = imageUrl
        )
    }
}