package com.example.sharedprefcrud.ViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sharedprefcrud.Helper.SharedPreferenceHelper
import kotlinx.coroutines.launch

class MainViewModel(private val context: Context): ViewModel() {
    private val sharedPreferenceHelper = SharedPreferenceHelper(context)

    fun saveData(key: String, value: String){
        viewModelScope.launch {
            sharedPreferenceHelper.saveData(key, value)
        }
    }

    fun getData(key: String): String? {
        return sharedPreferenceHelper.getData(key)
    }

    fun deleteData(key: String){
        viewModelScope.launch {
            sharedPreferenceHelper.deleteData(key)
        }
    }

    fun clearData(){
        viewModelScope.launch {
            sharedPreferenceHelper.clearData()
        }
    }
}