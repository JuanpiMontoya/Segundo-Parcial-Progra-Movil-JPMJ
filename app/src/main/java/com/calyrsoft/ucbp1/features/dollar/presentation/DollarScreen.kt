package com.calyrsoft.ucbp1.features.dollar.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
                    text = "Tipos de Cambio",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Actualizado: ${stateValue.data.fechaActualizacion ?: "N/A"}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                Text(
                    text = "🏦 Dolar Oficial: ${stateValue.data.dollarOfficial ?: "No disponible"} Bs.",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .padding(4.dp)
                        .background(Color.Green.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
                        .padding(8.dp)
                )
                Text(
                    text = "💰 Dolar Paralelo: ${stateValue.data.dollarParallel ?: "No disponible"} Bs.",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .padding(4.dp)
                        .background(Color.Yellow.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                        .padding(8.dp)
                )
                Text(
                    text = "₮ USDT: ${stateValue.data.USDT ?: "No disponible"} Bs.",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .padding(4.dp)
                        .background(Color.Magenta.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
                        .padding(8.dp)
                )
                Text(
                    text = "🔵 USDC: ${stateValue.data.USDC ?: "No disponible"} Bs.",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .padding(4.dp)
                        .background(Color.Blue.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
                        .padding(8.dp)
                )
            }
        }
    }
}


