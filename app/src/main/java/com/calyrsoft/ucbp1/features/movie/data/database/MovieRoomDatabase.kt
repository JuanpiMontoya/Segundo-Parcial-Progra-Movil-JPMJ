package com.calyrsoft.ucbp1.features.movie.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.calyrsoft.ucbp1.features.movie.data.database.dao.IMovieDao
import com.calyrsoft.ucbp1.features.movie.data.database.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MoviesRoomDatabase : RoomDatabase() {
    abstract fun movieDao(): IMovieDao

    companion object {
        @Volatile
        private var Instance: MoviesRoomDatabase? = null

        fun getDatabase(context: Context): MoviesRoomDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    MoviesRoomDatabase::class.java,
                    "movies_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
