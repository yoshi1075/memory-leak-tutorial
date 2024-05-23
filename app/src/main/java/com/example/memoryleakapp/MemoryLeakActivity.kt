package com.example.memoryleakapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import com.example.memoryleakapp.ui.theme.MemoryLeakAppTheme

class MemoryLeakActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemoryLeakAppTheme {
                LeakyComposable(context = LocalContext.current)
            }
        }
    }
}

object LeakyCompositionLocal {
    var current: Context? = null
}

@Composable
fun LeakyComposable(context: Context) {
    DisposableEffect(Unit) {
        LeakyCompositionLocal.current = context
        onDispose {
            // この処理をしないことでコンテキストが解放されない
        }
    }
    // 他のCompose UIコード
}
