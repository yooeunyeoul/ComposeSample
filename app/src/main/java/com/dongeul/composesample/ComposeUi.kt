package com.dongeul.composesample

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dongeul.composesample.ui.theme.ComposeSampleTheme


@Composable
fun Greeting(name: String) {
    var expanded by remember {
        mutableStateOf(value = false)
    }

    val extraPadding by animateDpAsState(
        targetValue = if (expanded) 48.dp else 0.dp,
        animationSpec = tween(
            durationMillis = 500
        )
    )

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
                onClick = { expanded = !expanded },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = if (expanded) "Show Less" else "Show More")
            }
        }
    }
}

@Composable
@Preview(showBackground = true, widthDp = 320, uiMode = UI_MODE_NIGHT_YES,name="PreviewGreeting")
@Preview
fun previewGreeting() {
    ComposeSampleTheme {
        Greetings()

    }
}

@Composable
fun MyApp() {
    var shouldShowOnboarding by rememberSaveable {
        mutableStateOf(true)
    }
    if (shouldShowOnboarding) {
        OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
    } else {
        Greetings()
    }
}

@Composable
fun Greetings(names: List<String> = List(1000) { "$it" }) {
    Surface(color = MaterialTheme.colors.background) {
        Column(Modifier.padding(vertical = 4.dp)) {
            LazyColumn {
                item { Text("Header") }
                items(names) { name ->
                    Greeting(name)
                }
                item { Text("Footer") }
            }


        }
    }
}