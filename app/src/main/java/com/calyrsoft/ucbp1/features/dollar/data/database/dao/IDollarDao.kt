package com.calyrsoft.ucbp1.features.dollar.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.calyrsoft.ucbp1.features.dollar.data.database.entity.DollarEntity

@Dao
interface IDollarDao {
    @Query("SELECT * FROM dollars")
    suspend fun getList(): List<DollarEntity>

    @Query("SELECT * FROM dollars ORDER BY timestamp DESC LIMIT 10")  // NUEVO ✅
    suspend fun getHistory(): List<DollarEntity>

    @Query("SELECT * FROM dollars ORDER BY timestamp DESC LIMIT 1")   // NUEVO ✅
    suspend fun getLatest(): DollarEntity?

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(dollar: DollarEntity)

    @Query("DELETE FROM dollars")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertDollars(lists: List<DollarEntity>)
}