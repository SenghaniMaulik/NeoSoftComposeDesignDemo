package com.example.neosoft.ui.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neosoft.ui.theme.register_bg

@Composable
fun RegisterScreen() {
    Box(
        Modifier
            .padding(16.dp)
            .background(register_bg)) {
        Column {
            RegisterHeader()

        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}