package com.example.neosoft.ui.presentation.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neosoft.ui.presentation.components.ProfileTextField
import com.example.neosoft.ui.theme.linearGradient
import kotlinx.coroutines.launch

@Composable
fun ProfileContent(viewModel: ProfileScreenViewModel) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.White)
            .padding(16.dp)
    ) {
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
                label = "Email Id",
                hint = "Enter Email",
                imageVector = Icons.Default.Email,
                value = viewModel.textFieldEmail,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Email
                ),
                onValueChange = { viewModel.textFieldEmail = it }
            )
            ProfileTextField(
                label = "Mobile Number",
                hint = "Enter your 10 digit mobile number",
                imageVector = Icons.Default.Phone,
                value = viewModel.textFieldMobile,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number
                ),
                onValueChange = { viewModel.textFieldMobile = it }
            )
            ProfileTextField(
                label = "Date of Birth",
                hint = "DD / MM / YYYY",
                imageVector = Icons.Default.Create,
                value = viewModel.textFieldDate,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Number
                ),
                onValueChange = { viewModel.textFieldDate = it }
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .clickable {
                        /*if (viewModel.textFieldUserName.isEmpty()) {
                            messageBarState.addError(Exception("Please enter name"))
                        } else if (signUpScreenViewModel.textFieldEmail.isEmpty()) {
                            messageBarState.addError(Exception("Please enter email"))
                        } else if (!isValidEmail(signUpScreenViewModel.textFieldEmail)) {
                            messageBarState.addError(Exception("Please enter valid email"))
                        } else if (signUpScreenViewModel.textFieldPassword.isEmpty()) {
                            messageBarState.addError(Exception("Please enter password"))
                        } else if (!validatePasswordInput(signUpScreenViewModel.textFieldPassword)) {
                            messageBarState.addError(Exception("Please enter valid password"))
                        } else {
                            coroutineScope.launch {
                                val userDataString = "${signUpScreenViewModel.textFieldName}," +
                                        "${signUpScreenViewModel.textFieldEmail}," +
                                        signUpScreenViewModel.textFieldPassword
                                context.saveString(
                                    PreferencesManager.KEY_STR_EMAIL_PASS,
                                    userDataString
                                )
                                context.saveBoolean(PreferencesManager.KEY_BOOL_IS_LOGIN, true)
                                navToHome(signUpScreenViewModel.textFieldName)
                            }
                        }*/
                    }
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .background(linearGradient)
                    .padding(10.dp),
                contentAlignment = Alignment.Center,

                ) {
                Text(text = "Save", fontSize = 20.sp, color = Color.White)
            }
        }
    }
}


@Preview
@Composable
fun ProfileContentPr() {
    ProfileContent(ProfileScreenViewModel())
}