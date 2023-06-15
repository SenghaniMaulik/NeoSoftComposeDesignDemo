package com.example.neosoft.ui.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neosoft.R
import com.example.neosoft.ui.theme.register_magento
import com.example.neosoft.ui.theme.register_pink

@Composable
fun RegisterHeader() {
    val linear = Brush.verticalGradient(listOf(register_pink, register_magento))
    Box(
        modifier = Modifier
            .background(linear)
            .height(250.dp)
            .fillMaxWidth()
    ) {

//        val gradientGreenRed = Brush.horizontalGradient(0f to colorGreen, 1000f to colorRed)

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.TopEnd)
            {

                Image(
                    painter = painterResource(R.drawable.img_person),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier

                        .size(150.dp)
                        .clip(CircleShape)                       // clip to the circle shape
                        .border(0.dp, Color.Gray, CircleShape)
                        .background(Color.White)   // add a border (optional)
                )
                EditIcon()
            }
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Lacey Fernandez", color = Color.White, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.width(8.dp))
                EditIcon()


            }

        }
    }
}

@Composable
fun EditIcon(
) {
    Box(
        modifier = Modifier
            .clickable { }
            .clip(CircleShape)
            .background(Color.White)
    )
    {
        Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = "Edit",
            modifier = Modifier.padding(5.dp)
        )


    }
}

@Preview
@Composable
fun RegisterHeaderHeader() {
    RegisterHeader()
}