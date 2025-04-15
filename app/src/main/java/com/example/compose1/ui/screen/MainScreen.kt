package com.example.compose1.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.compose1.R

@Composable
fun MainScreen(){
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello",
                fontSize = 24.sp,
                fontWeight = FontWeight.W900
            )

            Button(
                onClick = {
                }
            ) {
                Text(
                    text = "Click"
                )
            }

            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "image"
            )
        }
    }
}

@Preview
@Composable
fun MainScreen_Preview(){
    MainScreen()
}