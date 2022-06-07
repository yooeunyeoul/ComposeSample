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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dongeul.composesample.ui.theme.ComposeSampleTheme

@Composable
fun OnboardingScreen() {
    var shouldShowOnboarding by remember {
        mutableStateOf(true)
    }

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to the Basics Codelab")
            Button(modifier = Modifier.padding(vertical = 24.dp),
                onClick = {
                    shouldShowOnboarding = false
                }) {
                Text(text = "Continue")
            }
        }
    }
}

@Preview( showBackground =  true , widthDp = 320, heightDp = 320)
@Composable
fun prevOnBoarding(){
    MaterialTheme{
        OnboardingScreen()
    }
}