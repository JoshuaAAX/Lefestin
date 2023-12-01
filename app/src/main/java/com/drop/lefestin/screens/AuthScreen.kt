package com.drop.lefestin.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.ui.platform.LocalContext
import com.drop.lefestin.ViewModels.SupabaseAuthViewModel


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.drop.lefestin.R
import com.drop.lefestin.components.LoadingComponent
import com.drop.lefestin.data.model.UserState


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun AuthScreen(
    navController: NavController,
    viewModel: SupabaseAuthViewModel
) {
    val context = LocalContext.current
    val userState by viewModel.userState

    var userEmail by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }

    var currentUserState by remember { mutableStateOf("") }


    LaunchedEffect(Unit) {
        viewModel.isUserLoggedIn(
            context,

            )
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFCF0304))
            .padding(16.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {

            HeadImage(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))
            MainTextLoginJ(Modifier.align(Alignment.Start))

            Spacer(modifier = Modifier.padding(8.dp))

            TextField(
                value = userEmail,
                placeholder = { Text(text = "enter email") },
                onValueChange = { userEmail = it })

            Spacer(modifier = Modifier.padding(4.dp))

            TextField(value = userPassword,
                placeholder = { Text(text = "enter password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                maxLines = 1,
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = { userPassword = it })

            Spacer(modifier = Modifier.padding(8.dp))
            NoAccount(Modifier.align(Alignment.End), navController)
            Spacer(modifier = Modifier.padding(16.dp))

            Button(
                onClick = {
                    viewModel.login(
                        context,
                        userEmail,
                        userPassword,
                    )

                }) {
                Text(text = "Login")
            }


            when (userState) {
                is UserState.Loading -> {
                    LoadingComponent()
                }

                is UserState.Success -> {
                    val message = (userState as UserState.Success).message
                    currentUserState = message

                    if (message == "User already logged in!" || message == "Logged in succesfully!") {
                        navController.navigate("home")
                    }
                }

                is UserState.Error -> {
                    val message = (userState as UserState.Error).message
                    currentUserState = "Ingrese su email o contraseña de nuevo"
                    navController.navigate("home")
                }
            }

            if (currentUserState.isNotEmpty()) {
                Text(text = currentUserState)
            }

        }
    }
}

@Composable
fun HeadImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logolefestin),
        contentDescription = stringResource(R.string.header),
        modifier = modifier
    )
}

@Composable
fun MainTextLoginJ(modifier: Modifier) {
    Text(
        text = "Iniciar Sesión",
        modifier = modifier.clickable { },
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFFFFFF)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailFieldJ(email: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value = email, onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = stringResource(R.string.email)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF292727),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color(0xFFFFFFFF),
            placeholderColor = Color(0xFFCF0304),
        )

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldJ(password: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value = password,
        onValueChange = { onTextFieldChanged(it) },
        placeholder = { Text(text = "Contraseña") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFCF0304),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color(0xFFFFFFFF),
            placeholderColor = Color(0xFFCF0304)
        )
    )
}


@Composable
fun NoAccountJ(modifier: Modifier, navController: NavController) {
    Text(
        text = "No tienes una cuenta?",
        modifier = modifier.clickable { navController.navigate("register") },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFFFFFF)
    )
}


@Composable
fun loginButton(signUpEnable: Boolean, onSignUpSelected: () -> Unit) {
    Button(
        onClick = { onSignUpSelected() },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = buttonColors(
            containerColor = Color(0xFFFFFFFF),
            disabledContainerColor = Color(0xFF969392),
            contentColor = Color(0xFFCF0304),
            disabledContentColor = Color(0xFFCF0304),
        ), enabled = signUpEnable
    ) {
        Text(text = "Login")
    }
}

