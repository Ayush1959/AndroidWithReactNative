package com.example.testjdsapp.ui.presentation.screens.hijds

import android.content.Context
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.testjdsapp.ReactNativeApplication
import com.facebook.react.ReactRootView
import com.facebook.react.common.LifecycleState
import com.facebook.react.shell.MainReactPackage

@Composable
fun ReactNativeView(
    componentName: String = "HiJdsApp",
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val application = context.applicationContext as? ReactNativeApplication
    
    val reactRootView = remember {
        ReactRootView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }

    DisposableEffect(componentName) {
        application?.reactNativeHost?.reactInstanceManager?.let { reactInstanceManager ->
            reactRootView.startReactApplication(
                reactInstanceManager,
                componentName,
                null
            )
        }
        
        onDispose {
            reactRootView.unmountReactApplication()
        }
    }

    AndroidView(
        factory = { reactRootView },
        modifier = modifier.fillMaxSize()
    )
}
