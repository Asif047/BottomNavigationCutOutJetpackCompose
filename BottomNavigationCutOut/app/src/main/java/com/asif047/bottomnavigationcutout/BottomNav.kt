package com.asif047.bottomnavigationcutout

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNav(navController: NavController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.value?.destination
    BottomNavigation(
        modifier = Modifier
            .padding(12.dp, 0.dp, 12.dp, 0.dp)
            .height(100.dp),
        //backgroundColor = Color.White,
        elevation = 0.dp
    ) {
        items.forEach {
            BottomNavigationItem(
                icon = {
                    it.icon?.let {
                        Icon(
                            imageVector = it,
                            contentDescription = "",
                            modifier = Modifier.size(35.dp),
                            //tint = Color.Gray

                        )
                    }
                },
                label = {
                    it.title?.let {
                        Text(
                            text = it,
                            //color = Color.Gray
                        )
                    }
                },
                selected = currentRoute?.hierarchy?.any { it.route == it.route } == true,

                selectedContentColor = Color.Blue,
                unselectedContentColor = Color.White.copy(alpha = 0.4f),
                onClick = {
                    it.route?.let { it1 ->
                        navController.navigate(it1) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}