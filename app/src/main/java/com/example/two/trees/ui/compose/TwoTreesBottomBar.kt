package com.example.two.trees.ui.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.example.two.trees.MainViewModel
import com.example.two.trees.R

@Composable
fun ShowIcon(
    quantity: Int,
    screen: Screen
) {
    val label = stringResource(id = screen.labelResourceId)
    if (screen.route == Screen.Shop.route) {
        BadgedBox(
            badge = {
                if (quantity > 0) {
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ) {
                        Text("$quantity")
                    }
                }
            }
        ) {
            Icon(
                imageVector = screen.icon,
                contentDescription = label
            )
        }
    }
    else {
        Icon(
            imageVector = screen.icon,
            contentDescription = label
        )
    }
}

@Composable
fun TwoTreesBottomBar(
    navController: NavHostController,
    currentDestination: NavDestination?,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        // TODO: create a variable that has the current quantity
        // this is how we able to observe the quantity from ModelView
        val quantity by viewModel.quantity.collectAsStateWithLifecycle()
        screens.forEach { screen ->
            val label = stringResource(id = screen.labelResourceId)
            NavigationBarItem(
                icon = {
                    // TODO: update the icon to be a badged icon
                    // TODO: only display badge when quantity not zero
                    // TODO: and only on the shop screen
                    ShowIcon(quantity, screen)
                },
                label = {
                    Text(label)
                },
                selected = currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
