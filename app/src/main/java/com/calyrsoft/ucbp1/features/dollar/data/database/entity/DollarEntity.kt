package com.calyrsoft.ucbp1.features.dollar.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.calyrsoft.ucbp1.features.dollar.domain.model.DollarModel

@Entity(tableName = "dollars")
data class DollarEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "dollar_official") var dollarOfficial: String? = null,
    @ColumnInfo(name = "dollar_parallel") var dollarParallel: String? = null,
    @ColumnInfo(name = "USDT") var USDT: String? = null,
    @ColumnInfo(name = "USDC") var USDC: String? = null,
    @ColumnInfo(name = "timestamp") var timestamp: Long = 0
) {

    fun toModel(): DollarModel {
        return DollarModel(
            dollarOfficial = dollarOfficial.orEmpty(),
            dollarParallel = dollarParallel.orEmpty(),
            USDT = USDT.orEmpty(),
            USDC = USDC.orEmpty()
        )
    }
}