package com.asif047.bottomnavigationcutout

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.asif047.bottomnavigationcutout.screens.CameraScreen
import com.asif047.bottomnavigationcutout.screens.PickupScreen
import com.asif047.bottomnavigationcutout.screens.ProfileScreen

@Composable
fun MainScreenNavigation(navController: NavHostController) {

    NavHost(navController, startDestination = Screen.Profile.route!!) {

        //profile
        composable(Screen.Profile.route) {
             ProfileScreen()
        }
        //pickUp
        composable(Screen.PickUp.route!!) {
             PickupScreen()
        }

        //camera
        composable(Screen.Camera.route!!){
             CameraScreen()
        }
    }


}