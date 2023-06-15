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
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.neosoft.ui.presentation.components.DisplayAlertDialog
import com.example.neosoft.ui.presentation.components.ProfileTextField
import com.example.neosoft.ui.theme.linearGradient
import com.example.neosoft.ui.theme.register_pink
import com.stevdzasan.messagebar.MessageBarState

@Composable
fun ProfileContent(viewModel: ProfileScreenViewModel, messageBarState: MessageBarState) {


    var dialogOpened by remember { mutableStateOf(false) }


    
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

                Text(
                    text = "Sex",
                    style = MaterialTheme.typography.bodyLarge.copy(color = register_pink)
                )
                Switch(
                    checked = viewModel.mCheckedState,
                    onCheckedChange = { viewModel.mCheckedState = it })

                Spacer(modifier = Modifier.height(30.dp))

                Box(
                    modifier = Modifier
                        .clickable {
                            if (viewModel.textFieldUserName.isEmpty()) {
                                messageBarState.addError(Exception("Please enter username"))
                            } else if (viewModel.textFieldEmail.isEmpty()) {
                                messageBarState.addError(Exception("Please enter email"))
                            } else if (!isValidEmail(viewModel.textFieldEmail)) {
                                messageBarState.addError(Exception("Please enter valid email"))
                            } else if (viewModel.textFieldMobile.isEmpty()) {
                                messageBarState.addError(Exception("Please enter mobile no."))
                            } else if (!validatePasswordInput(viewModel.textFieldMobile)) {
                                messageBarState.addError(Exception("Please enter valid mobile no."))
                            } else if (viewModel.textFieldDate.isEmpty()) {
                                messageBarState.addError(Exception("Please enter birthdate."))
                            } else {
                                dialogOpened = true
                            }
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


    DisplayAlertDialog(
        title = "Please review details",
        message = "${viewModel.textFieldUserName} \n ${viewModel.textFieldEmail} \n ${viewModel.textFieldMobile} \n ${viewModel.textFieldDate}",
        dialogOpened = dialogOpened,
        onCloseDialog = { dialogOpened = false },
        onYesClicked = {
            dialogOpened = false
        },
    )
}


private fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex(pattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
    return emailRegex.matches(email)
}

fun validatePasswordInput(text: String): Boolean {
    // Perform your validation logic here
    // Return true if the input is valid, otherwise false
    return text.length >= 10
}

@Preview
@Composable
fun ProfileContentPr() {
//    ProfileContent(ProfileScreenViewModel(), messageBarState)
}