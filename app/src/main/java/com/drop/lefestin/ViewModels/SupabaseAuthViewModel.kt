package com.drop.lefestin.ViewModels

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import co.touchlab.kermit.Severity
import com.drop.lefestin.SupabaseHelper
import com.drop.lefestin.SupabaseHelper.client
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.ktor.client.engine.KTOR_DEFAULT_USER_AGENT
import kotlinx.coroutines.launch

class SupabaseAuthViewModel: ViewModel() {
    private val _userState = mutableStateOf<UserState>(UserState.Loading)
    val userState: State<UserState> = _userState

    fun signUp(
        context: Context,
        userEmail: String,
        userPassword: String,
        ){
        viewModelScope.launch {
            try {
                SupabaseHelper.client.gotrue.signUpWith(Email){
                    email = userEmail
                    password = userPassword
                }
                saveToke(context)
                _userState.value= UserState.Success("registered user success")

            }catch (e: Exception){
                _userState.value = UserState.Error("Error: ${e.message}")
            }
        }
    }

    private fun saveToke(context: Context) {
        viewModelScope.launch {
            val accessToken = client.gotrue.currentAccessTokenOrNull() ?: ""
            val sharedProf = SharedPreferenceHelper(context)
            sharedProf.saveStringData("accessToken", accessToken)
        }

    }

    private fun getToken(context: Context) :String? {
        val sharedProf = SharedPreferenceHelper(context)
        return sharedProf.getStringData("accessToken")
    }

    fun login(
        context: Context,
        userEmail: String,
        userPassword: String
    ){
        viewModelScope.launch {
            try {
                client.gotrue.loginWith(Email) {
                    email = userEmail
                    password = userPassword
                }
                saveToke(context)
                _userState.value = UserState.Success("Logged in sccesfully")
            } catch (e: Exception) {
                _userState.value = UserState.Error("Error: ${e.message}")
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            try {
                client.gotrue.logout()
                _userState.value = UserState.Success("logged out succesfully")
            } catch (e: Exception){
                _userState.value = UserState.Error("Error: ${e.message}")
            }
        }
    }

    fun isUserLoggedIn(
        context: Context
    ){
        viewModelScope.launch {
            try {
                val token = getToken(context)
                if(token.isNullOrEmpty()){
                    _userState.value = UserState.Error("User is not Logges in")
                } else {
                    client.gotrue.retrieveUser(token)
                    client.gotrue.refreshCurrentSession()
                    saveToke(context)
                    _userState.value = UserState.Success("user is alreasy logge in")
                }
            } catch (e : Exception) {
                _userState.value = UserState.Error("Error: ${e.message}")
            }
        }
    }
}