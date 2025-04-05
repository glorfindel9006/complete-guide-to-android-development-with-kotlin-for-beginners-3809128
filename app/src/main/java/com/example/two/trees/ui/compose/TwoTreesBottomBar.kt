package com.example.two.trees.ui.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController

@Composable
fun TwoTreesBottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar {
        // Here we are using iteration into our sealed class Screen
        // and we effectively create every NavigationBarItem
        screens.forEach { screen ->
            val label = stringResource(id = screen.labelResourceId)
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = label
                    )
                },
                label = {
                    Text(
                        label
                    )
                },
                selected = false,
                onClick = {
                    navController.navigate(screen.route) {
                        // this make sure only one copy of the activity being routed
                        // or else whenever we click the icon the activity is created
                        launchSingleTop = true
                    }
                }
            )
        }

        // This below are the duplicated way of defining each of the bottom bar icon and actions.
//        NavigationBarItem(
//            icon = {
//                Icon(
//                    imageVector = Icons.Filled.Home,
//                    contentDescription = "Home"
//                )
//            },
//            label = {
//                Text(
//                    "Home"
//                )
//            },
//            selected = false,
//            onClick = {}
//        )
//        NavigationBarItem(
//            icon = {
//                Icon(
//                    imageVector = Icons.Filled.Place,
//                    contentDescription = "Tours"
//                )
//            },
//            label = {
//                Text(
//                    "Tours"
//                )
//            },
//            selected = false,
//            onClick = {}
//        )
//        NavigationBarItem(
//            icon = {
//                Icon(
//                    imageVector = Icons.Filled.ShoppingCart,
//                    contentDescription = "Shop"
//                )
//            },
//            label = {
//                Text(
//                    "Shop"
//                )
//            },
//            selected = false,
//            onClick = {}
//        )
    }
}