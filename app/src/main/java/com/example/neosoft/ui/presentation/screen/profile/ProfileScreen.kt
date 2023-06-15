package com.example.neosoft.ui.presentation.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.neosoft.ui.theme.register_bg

@Composable
fun ProfileScreen() {
    val profileScreenViewModel: ProfileScreenViewModel = viewModel()
    Box(
        Modifier
            .background(register_bg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ProfileHeader()
                Box(Modifier.padding(top = 240.dp)) {
                    ProfileContent(viewModel = profileScreenViewModel)
                }

            }


        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    ProfileScreen()
}