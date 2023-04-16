package com.gdsdevtec.deliverycompose.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.gdsdevtec.deliverycompose.App
import com.gdsdevtec.deliverycompose.dao.ProductDao
import com.gdsdevtec.deliverycompose.ui.screen.home.HomeScreen
import com.gdsdevtec.deliverycompose.ui.screen.home.HomeScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                fabClick = {
                    startActivity(
                        Intent(this, ProductFormActivity::class.java)
                    )
                },
                content = {
                    val viewModel by viewModels<HomeScreenViewModel>()
                    HomeScreen(viewModel = viewModel)
                }
            )
        }
    }
}