package com.example.sharedprefcrud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.sharedprefcrud.ViewModel.MainViewModel
import com.example.sharedprefcrud.ViewModel.MainViewModelFactory
import com.example.sharedprefcrud.Views.MainScreen
import com.example.sharedprefcrud.ui.theme.SharedPrefCrudTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SharedPrefCrudTheme {
                Surface (
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ){
                    MainScreen(mainViewModel)
                }
            }
        }
    }
}

