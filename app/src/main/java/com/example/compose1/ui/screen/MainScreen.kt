package com.example.compose1.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose1.R
import com.example.compose1.ui.model.ItemModel

@Composable
fun MainScreen(item: ItemModel, clickable: () -> Unit) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Scaffold { padding ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            Image(
                painter = painterResource(id = item.imageId),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(5.dp)
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
            ) {
                Text(
                    modifier = Modifier
                        .clickable {
                            clickable()
                        },
                    text = item.name
                )
                Text(
                    modifier = Modifier
                        .clickable {
                            clickable()
                            isExpanded = !isExpanded
                        },
                    maxLines = if (isExpanded) 10 else 1,
                    text = item.content
                )
            }
        }
    }
}

@Composable
fun ReDialog(
    dialogState: MutableState<Boolean>,
    item: ItemModel,
    onSubmit: (String, String) -> Unit
) {
    var name by remember { mutableStateOf(item.name) }
    var content by remember { mutableStateOf(item.content) }

    AlertDialog(
        onDismissRequest = {
            dialogState.value = false
        },
        confirmButton = {
            TextButton(onClick = {
                onSubmit(name, content)
                dialogState.value = false
            }) {
                Text(text = "OK")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                dialogState.value = false
            }) {
                Text(text = "Cancel")
            }
        },
        title = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Name:")
                TextField(value = name, onValueChange = {
                    name = it
                })
                Text(text = "Content:")
                TextField(value = content, onValueChange = {
                    content = it
                })
            }
        }
    )
}