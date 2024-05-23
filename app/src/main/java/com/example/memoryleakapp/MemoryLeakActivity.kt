package com.example.memoryleakapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.memoryleakapp.ui.theme.MemoryLeakAppTheme

class MemoryLeakActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (innerClass == null) {
            innerClass = LeakyInnerClass()
        }
        setContent {
            MemoryLeakAppTheme {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Button(
                        onClick = { finish() }
                    ) {
                        Text(text = "Back")
                    }
                }
            }
        }
    }

    inner class LeakyInnerClass

    companion object {
        private var innerClass: LeakyInnerClass? = null
    }
}
