package com.example.testjdsapp.ui.presentation.screens.hijds

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.testjdsapp.ui.theme.TestJDSAppTheme

@Composable
fun HiJdsScreen(
    onNavigateToGreeting: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        // React Native view as the main content
        ReactNativeView(
            componentName = "HiJdsApp",
            modifier = Modifier.fillMaxSize()
        )
        
        // Navigation button overlay
        Button(
            onClick = onNavigateToGreeting,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .zIndex(1f)
        ) {
            Text(text = "Go to Greeting")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HiJdsScreenPreview() {
    TestJDSAppTheme {
        HiJdsScreen(onNavigateToGreeting = {})
    }
}
