package com.drop.lefestin

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Matrix
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cameraswitch
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.drop.lefestin.ViewModels.LoginViewModel
import com.drop.lefestin.ViewModels.SignUpViewModel
import com.drop.lefestin.ViewModels.SupabaseAuthViewModel
import com.drop.lefestin.components.PhotoBottomSheetContent
import com.drop.lefestin.screens.AddScreen
import com.drop.lefestin.screens.AuthScreen
import com.drop.lefestin.screens.CameraPreview
import com.drop.lefestin.screens.FavoriteScreen
import com.drop.lefestin.screens.HomeScreen
import com.drop.lefestin.screens.LoginScreen
import com.drop.lefestin.screens.ProfileScreen
import com.drop.lefestin.screens.SignUpScreen
import com.drop.lefestin.ui.theme.LefestinTheme
import kotlinx.coroutines.launch
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController
import com.drop.lefestin.ViewModels.MainViewModel as MainViewModel

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!hasRequiredPermissions()) {
            ActivityCompat.requestPermissions(
                this, CAMERAX_PERMISSIONS, 0
            )
        }

        setContent {
            LefestinApp {


                val scope = rememberCoroutineScope()
                val controller = remember {
                    LifecycleCameraController(applicationContext).apply {
                        setEnabledUseCases(
                            CameraController.IMAGE_CAPTURE or CameraController.VIDEO_CAPTURE
                        )
                    }
                }
                val viewModelMain = viewModel<MainViewModel>()
                val bitmaps by viewModelMain.bitmap.collectAsState()

                @Composable
                fun CamaraScreen(navController: NavController , viewModelMain: MainViewModel){
                Scaffold(
                    topBar = {

                    },
                    content = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            CameraPreview(
                                controller = controller,
                                modifier = Modifier
                                    .fillMaxSize()
                            )



                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.BottomCenter)
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                IconButton(
                                    onClick = {

                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Photo,
                                        contentDescription = "Open gallery"
                                    )
                                }

                                IconButton(
                                    onClick = {

                                        navController.navigate("profile")
                                        takePhoto(
                                            controller = controller,
                                            onPhotoTaken = viewModelMain::onTakePhoto
                                        )
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.PhotoCamera,
                                        contentDescription = "Take photo"
                                    )
                                }

                                IconButton(
                                    onClick = {
                                        controller.cameraSelector =
                                            if (controller.cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA) {
                                                CameraSelector.DEFAULT_FRONT_CAMERA
                                            } else CameraSelector.DEFAULT_BACK_CAMERA
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Cameraswitch,
                                        contentDescription = "Switch camera"
                                    )
                                }
                            }
                        }
                    }
                )}



                val navController = rememberNavController()
                //val navigateToRegister = {navController.navigate("register")}
                NavHost(navController = navController, startDestination = "auth") {


                    composable("auth") {
                        AuthScreen(navController, SupabaseAuthViewModel())
                    }
                    composable("camara") {
                        CamaraScreen(navController, viewModelMain)
                    }
                    composable("login") {
                        LoginScreen(LoginViewModel(), navController, SupabaseAuthViewModel())
                    }

                    composable("register") {
                        SignUpScreen(SignUpViewModel(), navController, SupabaseAuthViewModel())
                    }

                    composable("home") {
                        HomeScreen(navController)
                    }

                    composable("add") {
                        AddScreen(navController)
                    }

                    composable("favorite") {
                        FavoriteScreen(navController)
                    }

                    composable("profile") {
                        ProfileScreen(navController, SupabaseAuthViewModel(), viewModelMain )
                    }
                }

            }
        }
    }

    private fun takePhoto(
        controller: LifecycleCameraController,
        onPhotoTaken: (Bitmap) -> Unit
    ) {
        controller.takePicture(
            ContextCompat.getMainExecutor(applicationContext),
            object : ImageCapture.OnImageCapturedCallback() {
                override fun onCaptureSuccess(image: ImageProxy) {
                    super.onCaptureSuccess(image)

                    val matrix = Matrix().apply {
                        postRotate(image.imageInfo.rotationDegrees.toFloat())
                    }
                    val rotatedBitmap = Bitmap.createBitmap(
                        image.toBitmap(),
                        0,
                        0,
                        image.width,
                        image.height,
                        matrix,
                        true
                    )

                    onPhotoTaken(rotatedBitmap)
                    Log.d("MainActivity", "Foto tomada y pasada a onTakePhoto")
                }

                override fun onError(exception: ImageCaptureException) {
                    super.onError(exception)
                    Log.e("Camera", "Couldn't take photo: ", exception)
                }
            }
        )
    }

    private fun hasRequiredPermissions(): Boolean {
        return CAMERAX_PERMISSIONS.all {
            ContextCompat.checkSelfPermission(
                applicationContext,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    companion object {
        public val CAMERAX_PERMISSIONS = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
        )
    }

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LefestinTheme {

    }
}