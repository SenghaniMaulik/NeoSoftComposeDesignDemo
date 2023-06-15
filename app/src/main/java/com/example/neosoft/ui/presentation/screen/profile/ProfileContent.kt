package com.example.neosoft.ui.presentation.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neosoft.ui.presentation.components.ProfileTextField
import com.example.neosoft.ui.theme.register_pink

@Composable
fun ProfileContent(viewModel: ProfileScreenViewModel) {
    Box(modifier = Modifier.padding(16.dp).background(Color.White)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "USER PROFILE",

                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            ProfileTextField(
                label = "User Name",
                hint = "Enter User Name",
                value = viewModel.textFieldUserName,
                onValueChange = { viewModel.textFieldUserName = it }
            )
            ProfileTextField(
                label = "User Name",
                hint = "Enter User Name",
                value = viewModel.textFieldUserName,
                onValueChange = { viewModel.textFieldUserName = it }
            )
        }
    }
}


@Preview
@Composable
fun ProfileContentPr() {
    ProfileContent(ProfileScreenViewModel())
}