package com.example.neosoft.ui.presentation.screen.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProfileScreenViewModel : ViewModel() {
    var textFieldUserName by mutableStateOf("")
    var textFieldEmail by mutableStateOf("")
    var textFieldMobile by mutableStateOf("")
    var textFieldDate by mutableStateOf("")
    var mCheckedState by  mutableStateOf(false)
}