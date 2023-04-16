package com.gdsdevtec.deliverycompose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import com.gdsdevtec.deliverycompose.ui.screen.form.ProductFormScreen
import com.gdsdevtec.deliverycompose.ui.screen.form.ProductFormScreenViewModel
import com.gdsdevtec.deliverycompose.ui.theme.DeliveryComposeTheme

class ProductFormActivity : ComponentActivity() {
    private val viewModel: ProductFormScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeliveryComposeTheme {
                Surface {
                    ProductFormScreen(
                        viewModel = viewModel,
                        onSaveClick = {
                            finish()
                        }
                    )
                }
            }
        }
    }
}