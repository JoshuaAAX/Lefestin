package com.drop.lefestin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun DataAuthScreen(navController: NavController){
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFCF0304))
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ){
        Column( modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround) {
            TitleAuth()
            Spacer(modifier = Modifier.padding(20.dp))
            Auth()
            Spacer(modifier = Modifier.padding(20.dp))
            BotonAuth(navController)

        }
    }


}
@Composable
fun TitleAuth() {

    Text(text = "Autorización para el Tratamiento de Datos Personales",
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFFFFFF),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    )


}
@Composable
fun Auth(){
    Text(text = "LeFestin solicita tu autorización para recopilar y tratar tus datos personales de acuerdo con la siguiente información:\n" +
            "\n" +
            "1. Datos Personales Recopilados\n" +
            "\n" +
            "\n" +
            "LeFestin recopila la siguiente información:\n" +
            "\n" +
            "Información proporcionada por el usuario: Incluyendo, pero no limitado a, nombre, dirección de correo electrónico y otra información relevante proporcionada voluntariamente durante el uso de la aplicación.\n" +
            "\n" +
            "Información de uso: Datos sobre cómo interactúas con la aplicación, como las recetas que visualizas, los ingredientes que buscas y cualquier otra actividad dentro de la aplicación.\n" +
            "\n" +
            "2. Finalidades del Tratamiento de Datos\n" +
            "\n" +
            "\n" +
            "LeFestin utilizará tus datos personales con las siguientes finalidades:\n" +
            "\n" +
            "Proporcionar y mejorar nuestros servicios, incluyendo la personalización de las recetas y sugerencias de ingredientes.\n" +
            "\n" +
            "Enviar notificaciones relevantes sobre actualizaciones de la aplicación o nuevas características.\n" +
            "\n" +
            "Mejorar la experiencia del usuario y la calidad de nuestros servicios.\n" +
            "\n" +
            "3. Consentimiento\n" +
            "\n" +
            "Al utilizar la aplicación, otorgas tu consentimiento para el tratamiento de tus datos personales de acuerdo con los términos establecidos en esta autorización. Puedes retirar tu consentimiento en cualquier momento contactándonos en lefestin@gmail.com.\n" +
            "\n" +
            "4. Almacenamiento y Seguridad de Datos\n" +
            "\n" +
            "Los datos personales recopilados se almacenarán de manera segura y se procesarán de acuerdo con las mejores prácticas de seguridad de la industria.\n" +
            "\n" +
            "5. Derechos del Usuario\n" +
            "\n" +
            "Tienes el derecho de acceder, corregir, eliminar y oponerte al tratamiento de tus datos personales. Puedes ejercer estos derechos contactándonos en lefestin@gmail.com.\n" +
            "\n" +
            "6. Cambios en la Autorización\n" +
            "\n" +
            "Nos reservamos el derecho de modificar esta autorización en cualquier momento. Te notificaremos sobre cambios significativos mediante un aviso en la aplicación.",
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFFFFFF),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun BotonAuth(navController: NavController){
    TextButton(onClick = { navController.navigate("home") },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFFFFF),
            disabledContainerColor = Color(0xFF969392),
            contentColor = Color(0xFFCF0304),
            disabledContentColor = Color(0xFFCF0304),
        ),
    ) {
        Text(text = "Acepto", color = Color(0xFFCF0304))
    }
}