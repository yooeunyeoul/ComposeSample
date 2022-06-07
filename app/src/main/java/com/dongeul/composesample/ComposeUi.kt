package com.dongeul.composesample

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dongeul.composesample.ui.theme.ComposeSampleTheme


@Composable
fun Greeting(name: String) {
    val expanded = remember {
        mutableStateOf(value = false)
    }

    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(horizontal = 9.dp, vertical = 9.dp)
    ) {
        Row(Modifier.padding(24.dp)) {
            Column(
                Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(
                    text = "Hello"
                )
                Text(
                    text = name
                )
            }

            OutlinedButton(
                onClick = { expanded.value = !expanded.value },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = if (expanded.value) "Show Less" else "Show More")
            }
        }
    }
}

@Composable
@Preview
fun previewGreeting() {
    Greeting(name = "무조건 이야")
}

@Composable
fun MyApp(names: List<String>) {
    Surface(color = MaterialTheme.colors.background) {
        Column(Modifier.padding(vertical = 4.dp)) {
            for (name in names) {
                Greeting(name = name)
            }

        }
    }
}