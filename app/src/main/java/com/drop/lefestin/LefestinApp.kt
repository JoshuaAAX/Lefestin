package com.drop.lefestin

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.drop.lefestin.ui.theme.LefestinTheme

@Composable
fun LefestinApp(content: @Composable () -> Unit) {
    LefestinTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.primary
        ) {
            content()
        }
    }
}
