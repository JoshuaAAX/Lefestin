package com.drop.lefestin.ViewModels

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel(){

    private val _user = MutableLiveData<String>()
    val user : LiveData<String> = _user

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _signUpEnable = MutableLiveData<Boolean>()
    val signUpEnable : LiveData<Boolean> = _signUpEnable



    fun onSignUpChanged(user: String,email: String, password: String){

        _user.value = user
        _email.value = email
        _password.value = password
        _signUpEnable.value = isValidEmail(email) && isValidPassword(password) && isValidUser(user)
    }
    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isValidPassword(password: String): Boolean = password.length > 6
    private fun isValidUser(user: String): Boolean = user.length > 2
    fun onSignUpSelected(){

    }
}