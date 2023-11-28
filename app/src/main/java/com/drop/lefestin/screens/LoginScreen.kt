@file:OptIn(ExperimentalMaterial3Api::class)

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.drop.lefestin.R
import com.drop.lefestin.ViewModels.LoginViewModel
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavController
import com.drop.lefestin.ViewModels.SupabaseAuthViewModel
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(viewModel: LoginViewModel,
                navController: NavController,
                viewModelSupa: SupabaseAuthViewModel
) {

    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFCF0304))
            .padding(16.dp)
    ) {
        Login(Modifier.align(Alignment.Center), viewModel, navController,viewModelSupa)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(modifier: Modifier,
          viewModel: LoginViewModel,
          navController: NavController,
          viewModelSupa: SupabaseAuthViewModel
) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()

    val context = LocalContext.current
    val userState by viewModelSupa.userState

    var userEmail by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModelSupa.isUserLoggedIn(
            context,

        )
    }

    Column(modifier = modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp))
        MainTextLogin(Modifier.align(Alignment.Start))
        Spacer(modifier = Modifier.padding(8.dp))
        TextField(value = userEmail, placeholder = { Text(text = "enter email")}, onValueChange = {userEmail = it})
       //EmailField(email) { viewModel.onLoginChanged(it, password) }
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(value = userPassword, placeholder = { Text(text = "enter password")},keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            maxLines = 1,
            visualTransformation = PasswordVisualTransformation(), onValueChange = {userPassword = it})
       // PasswordField(password) { viewModel.onLoginChanged(email, it) }
        Spacer(modifier = Modifier.padding(8.dp))
        NoAccount(Modifier.align(Alignment.End), navController)
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = { viewModelSupa.login(context,userEmail,userPassword);  navController.navigate("home") } ) {
          Text(text = "Login")
        }
        //LoginButton(loginEnable, {  viewModel.onLoginSelected()   }, navController = navController)
    }
}

@Composable
fun MainTextLogin(modifier: Modifier) {
    Text(
        text = "Iniciar Sesión",
        modifier = modifier.clickable { },
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFFFFFF)
    )
}

@Composable
fun LoginButton(
    loginEnable: Boolean,
    onLoginSelected: suspend () -> Unit,
    navController: NavController, ) {
    Button(
        // onClick = { }, logica real
        onClick = { onLoginSelected;
           navController.navigate("home") },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFFFFF),
            disabledContainerColor = Color(0xFF969392),
            contentColor = Color(0xFFCF0304),
            disabledContentColor = Color(0xFFCF0304),
        ), enabled = loginEnable
    ) {
        Text(text = "Iniciar Sesión")
    }
}

@Composable
fun NoAccount(modifier: Modifier, navController: NavController) {
    Text(
        text = "No tienes una cuenta?",
        modifier = modifier.clickable { navController.navigate("register") },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFFFFFF)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {
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

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logolefestin),
        contentDescription = stringResource(R.string.header),
        modifier = modifier
    )
}

@Preview
@Composable
fun DefaultPreviewOfLoginScreen() {
    // LoginScreen(LoginViewModel(),  navController)

}

