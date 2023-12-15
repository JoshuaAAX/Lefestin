package com.drop.lefestin.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.drop.lefestin.R
import com.drop.lefestin.components.MainAppBar

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AddScreen(navController: NavController) {

    MainAppBar(navController) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color(0xFFCF0304))
                    .padding(16.dp)
            )
            {
                AddRecipe(Modifier.align(Alignment.Center))
            }
        }
    }

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AddRecipe(modifier: Modifier){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        var titleRecipe by remember { mutableStateOf("") }
        var descriptionRecipe by remember { mutableStateOf("") }
        var ingredientsRecipe by remember { mutableStateOf("") }
        var preparationRecipe by remember { mutableStateOf("") }

        LazyColumn{
            item {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = stringResource(R.string.new_recipe),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFFFFF))
                    Image(painter = painterResource(id = R.drawable.addimage), contentDescription = "Recipe Image")
                    Text(text = stringResource(R.string.recipe_title),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFFFFF))
                    TextField(
                        value = titleRecipe,
                        placeholder = { Text(text = "Add title") },
                        onValueChange = { titleRecipe = it })
                    Text(text = stringResource(R.string.description_recipe),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFFFFF))
                    TextField(
                        value = descriptionRecipe,
                        placeholder = { Text(text = "Add description") },
                        onValueChange = { descriptionRecipe = it })
                    Text(text = stringResource(R.string.add_ingredients),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFFFFF))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ){
                        TextField(
                            value = ingredientsRecipe,
                            placeholder = { Text(text = "Add ingredients") },
                            onValueChange = { ingredientsRecipe = it })
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                contentColor = colorResource(id = R.color.white),
                                containerColor = colorResource(id = R.color.white)
                            )
                        ) {
                            Text(text = stringResource(R.string.plus), color = Color(0xFFCF0304))
                        }
                    }
                    Text(text = stringResource(R.string.preparation_recipe),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFFFFF))
                    TextField(
                        value = preparationRecipe,
                        placeholder = { Text(text = "Add preparation") },
                        onValueChange = { preparationRecipe = it })
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.weight(1f)
                        .padding(8.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = colorResource(id = R.color.white),
                        containerColor = colorResource(id = R.color.white)
                    )
                ) {
                    Text(text = stringResource(R.string.add_recipe), color = Color(0xFFCF0304))
                }
            }
        }
    }
}