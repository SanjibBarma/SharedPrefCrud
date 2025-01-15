package com.example.sharedprefcrud.Helper

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceHelper(contex: Context) {
    private val sharedPreferences: SharedPreferences = contex.getSharedPreferences("user_data", Context.MODE_PRIVATE)

    fun saveData(key: String, value: String){
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getData(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun deleteData(key: String){
        val editor = sharedPreferences.edit()
        editor.remove(key)
        editor.apply()
    }

    fun clearData(){
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}