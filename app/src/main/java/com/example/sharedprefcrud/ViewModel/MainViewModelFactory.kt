package com.example.sharedprefcrud.ViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory (private val context: Context): ViewModelProvider.Factory{
    //create is used for create an instance of viewmodel
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(context) as T
    }
}
