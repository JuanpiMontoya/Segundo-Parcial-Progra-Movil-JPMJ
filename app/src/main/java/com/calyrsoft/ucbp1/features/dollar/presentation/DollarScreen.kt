package com.calyrsoft.ucbp1.features.dollar.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DollarScreen(viewModelDollar: DollarViewModel = koinViewModel()) {
    val state = viewModelDollar.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        when (val stateValue = state.value) {
            is DollarViewModel.DollarUIState.Error -> {
                Text(stateValue.message)
            }
            DollarViewModel.DollarUIState.Loading -> {
                CircularProgressIndicator()
            }
            is DollarViewModel.DollarUIState.Success -> {
                Text(
                    text = "Actualizado: ${stateValue.data.fechaActualizacion ?: "Fecha no disponible"}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text("USD Oficial: ${stateValue.data.dollarOfficial ?: "No disponible"}")
                Text("USD Paralelo: ${stateValue.data.dollarParallel ?: "No disponible"}")
                Text("USDT: ${stateValue.data.USDT ?: "No disponible"}")
                Text("USDC: ${stateValue.data.USDC ?: "No disponible"}")
            }
        }
    }
}


