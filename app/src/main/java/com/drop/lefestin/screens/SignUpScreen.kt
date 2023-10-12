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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.drop.lefestin.R
import com.drop.lefestin.ViewModels.SignUpViewModel

@Composable
fun SignUpScreen(viewModel: SignUpViewModel,navController: NavController){

    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFCF0304))
            .padding(16.dp)
    ){
        Login(Modifier.align(Alignment.Center), viewModel,navController)
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: SignUpViewModel,navController: NavController) {

    val user :String by viewModel.user.observeAsState(initial = "")
    val email :String by viewModel.email.observeAsState(initial = "")
    val password :String by viewModel.password.observeAsState(initial = "")
    val signUpEnable:Boolean by viewModel.signUpEnable.observeAsState(initial = false)
    Column(modifier = modifier){

        HeaderImageSignUp(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp))
        MainTextRegister(Modifier.align(Alignment.Start))
        Spacer(modifier = Modifier.padding(8.dp))
        UserFieldRegister(user) {viewModel.onSignUpChanged(it,email,password)}
        Spacer(modifier = Modifier.padding(4.dp))
        EmailFieldRegister(email) {viewModel.onSignUpChanged(user,it, password)}
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordFieldRegister(password){viewModel.onSignUpChanged(user,email, it)}
        Spacer(modifier = Modifier.padding(8.dp))
        HaveAnAccount(Modifier.align(Alignment.End), navController)
        Spacer(modifier = Modifier.padding(16.dp))
        SignUpButton(signUpEnable) {viewModel.onSignUpSelected()}
    }
}

@Composable
fun MainTextRegister(modifier: Modifier) {
    Text(text = "Registrate",
        modifier = modifier.clickable { },
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFFFFFF)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserFieldRegister(user:String, onTextFieldChanged:(String) ->  Unit) {
    TextField(value = user , onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Usuario") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
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
fun SignUpButton(signUpEnable: Boolean, onSignUpSelected: () -> Unit) {
    Button(
        onClick = {onSignUpSelected() },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFFFFF),
            disabledContainerColor = Color(0xFF969392),
            contentColor = Color(0xFFCF0304),
            disabledContentColor = Color(0xFFCF0304),
        ), enabled = signUpEnable
    ){
        Text(text = "Registrarse")
    }
}

@Composable
fun HaveAnAccount(modifier: Modifier,navController: NavController) {
    Text(text = "Ya tienes una cuenta?",
        modifier = modifier.clickable { navController.navigate("login")},
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFFFFFF)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldRegister(password:String, onTextFieldChanged:(String) ->  Unit) {
    TextField(value = password, onValueChange = {onTextFieldChanged(it)},
        placeholder = { Text(text = "Contraseña") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
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
fun EmailFieldRegister(email:String, onTextFieldChanged:(String) ->  Unit) {
    TextField(value = email, onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
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
fun HeaderImageSignUp(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logolefestin),
        contentDescription = "Header",
        modifier = modifier
    )
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    //SignUpScreen(SignUpViewModel(),navController)

}
