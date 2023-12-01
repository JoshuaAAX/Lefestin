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
fun TermsandConditionsScreen(navController: NavController){
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
            Title()
            Spacer(modifier = Modifier.padding(20.dp))
            Terms()
            Spacer(modifier = Modifier.padding(20.dp))
            botoncito(navController)

        }
    }


}
@Composable
fun Title() {

    Text(text = "Términos Y Condiciones de Uso de LeFestin",
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFFFFFF),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    )


}
@Composable
fun Terms(){
    Text(text = "Al acceder y utilizar la aplicación LeFestin (\"la Aplicación\"), aceptas cumplir con estos Términos y Condiciones de Uso. Si no estás de acuerdo con alguno de estos términos, no utilices la aplicación.\n" +
            "\n" +
            "Uso de la Aplicación\n" +
            "\n" +
            "LeFestin proporciona recetas y contenido relacionado con la cocina con fines informativos. No nos hacemos responsables por cualquier resultado adverso que pueda surgir del uso de la información proporcionada.\n" +
            "Eres responsable de la exactitud de la información que compartes en la aplicación, incluyendo recetas, comentarios y cualquier otro contenido generado por el usuario.\n" +
            "\n" +"Derechos de Propiedad Intelectual\n" +
            "\n" +
            "Todo el contenido de la aplicación, incluyendo textos, imágenes, y marcas registradas, está protegido por derechos de autor y otros derechos de propiedad intelectual.\n" +
            "\n" +"Privacidad\n" +"\n" +
            "LeFestin recopila, almacena y procesa información de acuerdo con nuestra Política de Privacidad. Al utilizar la aplicación, aceptas los términos de dicha política.\n" +
            "\n" +"Enlaces a Terceros\n" +
            "\n" +
            "La aplicación puede contener enlaces a sitios web de terceros. No nos hacemos responsables por el contenido o las prácticas de privacidad de estos sitios.\n" +
            "\n" +"Limitación de Responsabilidad\n" +
            "\n" +
            "LeFestin no se hace responsable de daños directos, indirectos, incidentales, consecuentes o especiales que puedan surgir del uso de la aplicación.\n" +
            "Modificaciones de los Términos y Condiciones\n" +
            "\n" +
            "Nos reservamos el derecho de modificar estos Términos y Condiciones en cualquier momento. Las modificaciones entrarán en vigencia inmediatamente después de su publicación en la aplicación.\n" +
            "Ley Aplicable\n" +
            "\n" +
            "Estos Términos y Condiciones se rigen por las leyes de Colombia y cualquier disputa se someterá a la jurisdicción exclusiva de los tribunales de Cali.\n" +
            "Al utilizar LeFestin, aceptas estos Términos y Condiciones. Si tienes alguna pregunta, contáctanos en LeFestin@gmail.com",
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFFFFFF),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun botoncito(navController: NavController){
    TextButton(onClick = { navController.navigate("privacy") },
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
