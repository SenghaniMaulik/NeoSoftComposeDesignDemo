package com.example.neosoft.ui.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neosoft.ui.theme.linearGradient
import com.example.neosoft.ui.theme.register_pink

@Composable
fun ProfileTextField(
    label: String,
    hint: String,
    value: String,
    imageVector: ImageVector = Icons.Default.Person,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next,
    ),
    onValueChange: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge.copy(color = register_pink)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .background(Color.White)
                .border(
                    border = ButtonDefaults.outlinedButtonBorder,
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(linearGradient)
                        .padding(8.dp)
                )
                {
                    Icon(
                        imageVector = imageVector,
                        contentDescription = null,
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))
                BasicTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = value,
                    keyboardOptions = keyboardOptions,
                    decorationBox = { innerTextField ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                        ) {

                            if (value.isEmpty()) {
                                Text(
                                    hint,
                                    color = Color.Gray,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        }
                        // <-- Add this
                        innerTextField()
                    },
                    onValueChange = onValueChange,
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}


@Preview
@Composable
fun ProfileTextFieldPrev() {
    ProfileTextField(label = "User Name", hint = "Enter user Name", "", onValueChange = {})
}