package com.drop.lefestin.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainAppBar( navController: NavController, content: @Composable (innerPadding: androidx.compose.foundation.layout.PaddingValues) -> Unit) {
    Scaffold(
        bottomBar = {
            MainBottomAppBar(navController)
        },
        content = {innerPadding ->
            content(innerPadding)
        }
    )

}