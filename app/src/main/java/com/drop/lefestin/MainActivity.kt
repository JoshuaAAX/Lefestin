package com.drop.lefestin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.drop.lefestin.ViewModels.LoginViewModel
import com.drop.lefestin.ViewModels.SignUpViewModel
import com.drop.lefestin.screens.AddScreen
import com.drop.lefestin.screens.FavoriteScreen
import com.drop.lefestin.screens.HomeScreen
import com.drop.lefestin.screens.LoginScreen
import com.drop.lefestin.screens.ProfileScreen
import com.drop.lefestin.screens.SignUpScreen
import com.drop.lefestin.ui.theme.LefestinTheme
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getData()
        setContent {
            LefestinApp {

                val navController = rememberNavController()
                //val navigateToRegister = {navController.navigate("register")}
                NavHost(navController = navController, startDestination = "login"){

                    composable("login"){
                        LoginScreen(LoginViewModel(),navController)
                    }

                    composable("register"){
                        SignUpScreen(SignUpViewModel(),navController)
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
                        ProfileScreen(navController)
                    }
                }

            }
        }
    }


    private fun loginUser(email: String, password: String) {
        lifecycleScope.launch {
            try {
                val client = getClient()
                val response = client.gotrue.loginWith(Email) {
                    this.email = email
                    this.password = password
                }
                Log.i("response user", "funciono")


            } catch (e: Exception) {
                Log.e("Login Error", "Unknown error occurred")
            }
        }
    }

    private fun getData() {
        lifecycleScope.launch {

            val client = getClient()
            val supabaseResponse = client.postgrest["recipe"].select().decodeList<Repice>()

            // Accede al primer elemento si la lista no está vacía
            Log.i("supabase->response", supabaseResponse.toString())

        }
    }

    private fun getClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://ndefbaxquzwcbjcepffc.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im5kZWZiYXhxdXp3Y2JqY2VwZmZjIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTY5NzE2NDIsImV4cCI6MjAxMjU0NzY0Mn0.jtPRy4cMMpkbuZpBwiQhlTQpBsVl611Xm72ygtZkyCY"
        ) {
            install(Postgrest)
            install(GoTrue)
        }
    }

}


@Serializable
data class Repice(
    @SerialName("id_recipe")
    val id: Int,
    @SerialName("name_recipe")
    val name_recipe: String,
)


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LefestinTheme {

    }
}