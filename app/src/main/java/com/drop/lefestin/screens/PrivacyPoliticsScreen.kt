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
fun PrivacyPoliticsScreen(navController: NavController){
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
            TitleP()
            Spacer(modifier = Modifier.padding(20.dp))
            Politics()
            Spacer(modifier = Modifier.padding(20.dp))
            botonpoliticas(navController)

        }
    }


}
@Composable
fun TitleP() {

    Text(text = "Política de Privacidad de LeFestin",
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFFFFFF),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    )


}
@Composable
fun Politics(){
    Text(text = "1. Información que Recopilamos\n" +
            "LeFestin recopila la siguiente información:\n" +
            "\n" +
            "Información proporcionada por el usuario: Podemos recopilar información personal que nos proporciones directamente, como tu nombre, dirección de correo electrónico, y otra información relevante cuando interactúas con la aplicación.\n" +
            "\n" +
            "Información de uso: Recopilamos información sobre cómo utilizas la aplicación, incluyendo las recetas que visualizas, los ingredientes que buscas y cualquier otra actividad dentro de la aplicación.\n" +
            "\n" +
            "2. Uso de la Información\n" +
            "\n" +
            "Utilizamos la información recopilada para:\n" +
            "\n" +
            "Proporcionar y mejorar nuestros servicios, incluyendo la personalización de las recetas y sugerencias de ingredientes.\n" +
            "\n" +
            "Enviar notificaciones relevantes sobre actualizaciones de la aplicación o nuevas características.\n" +
            "\n" +
            "Mejorar la experiencia del usuario y la calidad de nuestros servicios.\n" +
            "\n" +
            "3. Compartir Información con Terceros\n" +
            "\n" +
            "No compartiremos tu información personal con terceros sin tu consentimiento, excepto cuando sea necesario para proporcionar nuestros servicios o cumplir con requisitos legales.\n" +
            "\n" +
            "4. Almacenamiento de Datos\n" +
            "\n" +
            "La información recopilada se almacena en servidores seguros y se procesa de acuerdo con las mejores prácticas de seguridad de la industria.\n" +
            "\n" +
            "5. Cookies y Tecnologías Similares\n" +
            "\n" +
            "Utilizamos cookies y tecnologías similares para mejorar la funcionalidad y la experiencia del usuario. Puedes gestionar las preferencias de cookies en la configuración de tu dispositivo.\n" +
            "\n" +
            "6. Enlaces a Sitios de Terceros\n" +
            "\n" +
            "Nuestra aplicación puede contener enlaces a sitios web de terceros. No nos hacemos responsables por las prácticas de privacidad de estos sitios y te recomendamos revisar sus políticas de privacidad.\n" +
            "\n" +
            "7. Cambios en la Política de Privacidad\n" +
            "\n" +
            "Nos reservamos el derecho de modificar esta política en cualquier momento. Te notificaremos sobre cambios significativos mediante un aviso en la aplicación.\n" +
            "\n" +
            "8. Contacto\n" +
            "\n" +
            "Si tienes preguntas o inquietudes sobre nuestra política de privacidad, puedes ponerte en contacto con nosotros en LeFestin@gmail.com",
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFFFFFF),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun botonpoliticas(navController: NavController){
    TextButton(onClick = { navController.navigate("dataauth") },
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