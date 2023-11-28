package com.drop.lefestin

import android.util.Log
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.buildJsonObject
import org.slf4j.MDC.put

object SupabaseHelper {
    suspend fun loginUser(logEmail: String, logPassword: String) {
        try {
            val client = client
            val response = client.gotrue.loginWith(Email){
                email = logEmail
                password = logPassword
            }
            Log.e("response login user", response.toString())
        } catch (e: Exception) {
            Log.e("Login Error", e.toString())
        }
    }

    suspend fun registerUser(regEmail: String, regPassword: String) {
        try {
            val client = client
            val response = client.gotrue.signUpWith(Email) {
                email = regEmail
                password = regPassword

            }
            Log.e("response sign up user", response.toString())
        } catch (e: Exception) {
            Log.e("sign up  Error", e.toString())
        }
    }
    suspend fun getData() {
        try {
            val client = client
            val supabaseResponse = client.postgrest["recipe"].select().decodeList<Repice>()

            // Accede al primer elemento si la lista no está vacía
            Log.d("supabase->response", supabaseResponse.toString())
        } catch (e: Exception) {
            Log.e("Supabase Error", "Error fetching data from Supabase")
        }
    }


    val client = createSupabaseClient(
            supabaseUrl = "https://ndefbaxquzwcbjcepffc.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im5kZWZiYXhxdXp3Y2JqY2VwZmZjIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTY5NzE2NDIsImV4cCI6MjAxMjU0NzY0Mn0.jtPRy4cMMpkbuZpBwiQhlTQpBsVl611Xm72ygtZkyCY"
    ) {
            install(Postgrest)
            install(GoTrue)
    }

}

@Serializable
data class Repice(
    @SerialName("id_recipe")
    val id: Int,
    @SerialName("name_recipe")
    val name_recipe: String,
)