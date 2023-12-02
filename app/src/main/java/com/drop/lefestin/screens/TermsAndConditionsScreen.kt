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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.drop.lefestin.R


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
    Text(text = stringResource(R.string.al_acceder_y_utilizar_la_aplicaci_n_lefestin_la_aplicaci_n_aceptas_cumplir_con_estos_t_rminos_y_condiciones_de_uso_si_no_est_s_de_acuerdo_con_alguno_de_estos_t_rminos_no_utilices_la_aplicaci_n_uso_de_la_aplicaci_n_lefestin_proporciona_recetas_y_contenido_relacionado_con_la_cocina_con_fines_informativos_no_nos_hacemos_responsables_por_cualquier_resultado_adverso_que_pueda_surgir_del_uso_de_la_informaci_n_proporcionada_eres_responsable_de_la_exactitud_de_la_informaci_n_que_compartes_en_la_aplicaci_n_incluyendo_recetas_comentarios_y_cualquier_otro_contenido_generado_por_el_usuario_derechos_de_propiedad_intelectual_todo_el_contenido_de_la_aplicaci_n_incluyendo_textos_im_genes_y_marcas_registradas_est_protegido_por_derechos_de_autor_y_otros_derechos_de_propiedad_intelectual_privacidad_lefestin_recopila_almacena_y_procesa_informaci_n_de_acuerdo_con_nuestra_pol_tica_de_privacidad_al_utilizar_la_aplicaci_n_aceptas_los_t_rminos_de_dicha_pol_tica_enlaces_a_terceros_la_aplicaci_n_puede_contener_enlaces_a_sitios_web_de_terceros_no_nos_hacemos_responsables_por_el_contenido_o_las_pr_cticas_de_privacidad_de_estos_sitios_limitaci_n_de_responsabilidad_lefestin_no_se_hace_responsable_de_da_os_directos_indirectos_incidentales_consecuentes_o_especiales_que_puedan_surgir_del_uso_de_la_aplicaci_n_modificaciones_de_los_t_rminos_y_condiciones_nos_reservamos_el_derecho_de_modificar_estos_t_rminos_y_condiciones_en_cualquier_momento_las_modificaciones_entrar_n_en_vigencia_inmediatamente_despu_s_de_su_publicaci_n_en_la_aplicaci_n_ley_aplicable_estos_t_rminos_y_condiciones_se_rigen_por_las_leyes_de_colombia_y_cualquier_disputa_se_someter_a_la_jurisdicci_n_exclusiva_de_los_tribunales_de_cali_al_utilizar_lefestin_aceptas_estos_t_rminos_y_condiciones_si_tienes_alguna_pregunta_cont_ctanos_en_lefestin_gmail_com),
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
