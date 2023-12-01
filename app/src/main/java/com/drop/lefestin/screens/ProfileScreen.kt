package com.drop.lefestin.screens

import android.widget.ScrollView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.drop.lefestin.R
import com.drop.lefestin.ViewModels.LoginViewModel
import com.drop.lefestin.ViewModels.SupabaseAuthViewModel
import com.drop.lefestin.components.MainAppBar
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.res.colorResource

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ProfileScreen(navController: NavController) {

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
                Profile(Modifier.align(Alignment.Center), navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(modifier: Modifier,
            navController: NavController
) {
    var userName by remember { mutableStateOf("") }
    var userEmail by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.weight(1f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pictureprofile),
                contentDescription = stringResource(R.string.header),
                modifier = modifier
            )
        }
        Text(text = stringResource(R.string.user),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFFFFF))
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            text = stringResource(R.string.edit_profile),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFFFFF))
        LazyColumn {
            item {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = stringResource(R.string.user_name),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFFFFF))
                    TextField(
                        value = userName,
                        placeholder = { Text(text = "Name") },
                        onValueChange = { userName = it })
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = stringResource(R.string.user_email),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFFFFF))
                    TextField(
                        value = userEmail,
                        placeholder = { Text(text = "Email") },
                        onValueChange = { userEmail = it })
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = stringResource(R.string.user_pass),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFFFFF))
                    TextField(value = userPassword,
                        placeholder = { Text(text = "Change Password") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        maxLines = 1,
                        visualTransformation = PasswordVisualTransformation(),
                        onValueChange = { userPassword = it })
                    Spacer(modifier = Modifier.padding(16.dp))
                    Text(text = "Términos, Condiciones y Tratamiento de datos",
                        modifier = modifier.clickable { navController.navigate("terms") },
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFFFFF))
                    Spacer(modifier = Modifier.padding(16.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = colorResource(id = R.color.white),
                                containerColor = colorResource(id = R.color.white)
                            )
                        ) {
                            Text(text = stringResource(R.string.save_changes), color = Color(0xFFCF0304))
                        }

                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = colorResource(id = R.color.white),
                                containerColor = colorResource(id = R.color.white)
                            )
                        ) {
                            Text(text = stringResource(R.string.log_out), color = Color(0xFFCF0304))
                        }
                    }

                    Spacer(modifier = Modifier.padding(25.dp))

                }
            }
        }
    }
}
