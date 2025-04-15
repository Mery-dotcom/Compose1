package com.example.compose1.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.compose1.R
import com.example.compose1.ui.model.ItemModel
import com.example.compose1.ui.screen.MainScreen
import com.example.compose1.ui.screen.ReDialog
import com.example.compose1.ui.theme.Compose1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose1Theme {
                val dialog = remember {
                    mutableStateOf(false)
                }

                val itemState = remember {
                    mutableStateOf(
                        ItemModel(
                            imageId = R.drawable.solo,
                            name = "Name",
                            content = "Content"
                        )
                    )
                }

                MainScreen(
                    item = itemState.value,
                    clickable = {
                        dialog.value = true
                    }
                )
                if (dialog.value) {
                    ReDialog(
                        dialogState = dialog,
                        item = itemState.value,
                        onSubmit = { name, content ->
                            itemState.value = itemState.value.copy(name = name, content = content)
                        }
                    )
                }
            }
        }
    }
}
