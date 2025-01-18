package com.example.sharedprefcrud.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sharedprefcrud.ViewModel.MainViewModel

@Composable
fun MainScreen (mainViewModel: MainViewModel){

    var  key by remember { mutableStateOf("") }
    var  value by remember { mutableStateOf("") }
    var  result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            "SharedPref Crud",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = key,
            onValueChange = {key = it},
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            singleLine = true,
            placeholder = { Text("Enter KEY") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = value,
            onValueChange = {value = it},
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            singleLine = true,
            placeholder = { Text("Enter Value") }
        )


        Spacer(modifier = Modifier.height(8.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(onClick = {
                mainViewModel.saveData(key, value)
                result = "Data Saved"
                key = ""
                value = ""
            }) {
                Text("Save")
            }

            Button(onClick = {
                result = mainViewModel.getData(key) ?: "Data not found!"
                key = ""
                value = ""
            }) {
                Text("Get")
            }

            Button(onClick = {
                mainViewModel.deleteData(key)
                result = "Data deleted"
                key = ""
                value = ""
            }) {
                Text("Delete")
            }

            Button(onClick = {
                mainViewModel.clearData()
                result = "All data clear"
                key = ""
                value = ""
            }) {
                Text("Clear")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(result)
    }
}