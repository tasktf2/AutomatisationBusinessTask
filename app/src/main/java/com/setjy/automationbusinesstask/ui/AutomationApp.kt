package com.setjy.automationbusinesstask.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Checkroom
import androidx.compose.material.icons.outlined.Store
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.setjy.automationbusinesstask.ui.screen.goods.GoodsScreen
import com.setjy.automationbusinesstask.ui.screen.goods.GoodsViewModel
import com.setjy.automationbusinesstask.ui.screen.store.StoreScreen
import com.setjy.automationbusinesstask.ui.screen.store.StoreViewModel
import com.setjy.automationbusinesstask.ui.theme.DarkGray
import com.setjy.automationbusinesstask.ui.theme.DarkGrayishBlue
import com.setjy.automationbusinesstask.ui.theme.LightGrayishBlue

enum class BottomMenu(val icon: ImageVector) {
    Goods(Icons.Outlined.Checkroom),
    Stores(Icons.Outlined.Store)
}

@Composable
fun AutomationApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { AppTopBar(navController) },
        bottomBar = { AppBottomNavigation(navController) }) {
        NavHost(
            navController = navController,
            startDestination = BottomMenu.Goods.name,
            modifier = modifier.padding(it)
        ) {
            composable(route = BottomMenu.Goods.name) {
                val viewModel: GoodsViewModel = hiltViewModel()
                GoodsScreen(
                    uiState = viewModel.uiState,
                    onTryAgainClicked = { viewModel.getProducts() })
            }
            composable(route = BottomMenu.Stores.name) {
                val viewModel: StoreViewModel = hiltViewModel()
                StoreScreen(uiState = viewModel.uiState,
                    onTryAgainClicked = { viewModel.getStoreList() })
            }
        }
    }
}

@Composable
private fun AppTopBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val title = when (navBackStackEntry?.destination?.route ?: BottomMenu.Goods.name) {
        BottomMenu.Goods.name -> "Товары"
        BottomMenu.Stores.name -> "Магазины"
        else -> "Заголовок"
    }
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        backgroundColor = MaterialTheme.colors.background
    )
}

@Composable
private fun AppBottomNavigation(navController: NavHostController) {
    BottomNavigation(backgroundColor = MaterialTheme.colors.background) {
        val menuItems = listOf(BottomMenu.Goods, BottomMenu.Stores)
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: BottomMenu.Goods.name
        menuItems.forEach { menuItem ->
            BottomNavigationItem(
                selected = currentRoute == menuItem.name,
                onClick = { navController.navigate(menuItem.name) },
                icon = {
                    Icon(imageVector = menuItem.icon, contentDescription = menuItem.name)
                },
                selectedContentColor = DarkGrayishBlue,
                unselectedContentColor = DarkGray,
                modifier = if (currentRoute == menuItem.name) {
                    Modifier.background(
                        color = LightGrayishBlue,
                        shape = MaterialTheme.shapes.large
                    )
                } else {
                    Modifier
                }
            )
        }
    }
}