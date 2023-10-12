package com.drop.lefestin.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainBottomAppBar(navController: NavController) {
    BottomAppBar(

        actions = {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                AppBarIcon(
                    imageVector = Icons.Rounded.Home,
                    onClick = { navController.navigate("home") },
                )

                AppBarIcon(
                    imageVector = Icons.Rounded.Add,
                    onClick = { navController.navigate("add") },
                )

                AppBarIcon(
                    imageVector = Icons.Rounded.Star,
                    onClick = { navController.navigate("favorite") },
                )

                AppBarIcon(
                    imageVector = Icons.Rounded.Person,
                    onClick = { navController.navigate("profile") },
                )
            }

        }
    )
}


@Composable
private fun AppBarIcon(
    imageVector: ImageVector,
    onClick: () -> Unit,

) {
    IconButton(
        onClick = onClick,
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = "Add Icon",
            modifier = Modifier.size(34.dp)
        )
    }
}