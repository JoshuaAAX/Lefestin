
package com.drop.lefestin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.drop.lefestin.ViewModels.LoginViewModel
import com.drop.lefestin.ViewModels.SignUpViewModel
import com.drop.lefestin.ViewModels.SupabaseAuthViewModel
import com.drop.lefestin.screens.AddScreen
import com.drop.lefestin.screens.AuthScreen
import com.drop.lefestin.screens.FavoriteScreen
import com.drop.lefestin.screens.HomeScreen
import com.drop.lefestin.screens.LoginScreen
import com.drop.lefestin.screens.ProfileScreen
import com.drop.lefestin.screens.SignUpScreen
import com.drop.lefestin.ui.theme.LefestinTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LefestinApp {

                val navController = rememberNavController()
                //val navigateToRegister = {navController.navigate("register")}
                NavHost(navController = navController, startDestination = "auth"){


                    composable("auth"){
                        AuthScreen(navController, SupabaseAuthViewModel())
                    }
                    composable("login"){
                        LoginScreen(LoginViewModel(),navController, SupabaseAuthViewModel())
                    }

                    composable("register"){
                        SignUpScreen(SignUpViewModel(),navController, SupabaseAuthViewModel())
                    }

                    composable("home"){
                        HomeScreen(navController)
                    }

                    composable("add"){
                        AddScreen(navController)
                    }

                    composable("favorite"){
                        FavoriteScreen(navController)
                    }

                    composable("profile"){
                        ProfileScreen(navController, SupabaseAuthViewModel())
                    }
                }

            }
        }
    }

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LefestinTheme {

    }
}