package com.gdsdevtec.deliverycompose.ui.screen.form

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gdsdevtec.deliverycompose.R

@Composable
fun ProductFormScreen(
    viewModel: ProductFormScreenViewModel,
    onSaveClick: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()
    ProductFormScreen(state = state, onSaveClick = {
        viewModel.save()
        onSaveClick()
    })
}


//onSaveClick = {

//}

@Composable
fun ProductFormScreen(
    state: ProductFormScreenUiState,
    onSaveClick: () -> Unit = {},
) {
    val url = state.url
    val name = state.name
    val price = state.price
    val description = state.description
    Column(
        Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier)
        Text(text = "Criando produto", fontSize = 28.sp)
        if (state.isShowPreview) {
            AsyncImage(
                model = url,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder),
            )
        }
        if (state.isShowPreview) AsyncImage(model = url, contentDescription = null)
        TextField(
            value = url,
            onValueChange = { state.onUrlChange },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Url da imagem") },
            placeholder = {
                Text(text = "Imagem")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            ),
        )
        TextField(
            value = name,
            onValueChange = { state.onNameChange },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Nome") },
            placeholder = {
                Text(text = "Nome")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            ),
            maxLines = 1
        )
//                var isPriceError by remember {mutableStateOf(false)}
        TextField(
            value = price,
            onValueChange = { state.onPriceChange },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Preço") },
            placeholder = {
                Text(text = "Preço")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            ),
            maxLines = 1,
//                    isError = isPriceError
        )
//                if (isPriceError) {
//                    Text(
//                        text = "Preço deve ser um número decimal",
//                        color = MaterialTheme.colors.error,
//                        style = MaterialTheme.typography.caption,
//                        modifier = Modifier.padding(start = 16.dp)
//                    )
//                }
        TextField(
            value = description, onValueChange = { state.onDescriptionChange },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp, max = 500.dp),
            label = { Text(text = "descriçao") },
            placeholder = {
                Text(text = "descriçao")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Sentences
            )
        )
        Button(
            onClick = onSaveClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Salvar")
        }
        Spacer(modifier = Modifier)
    }
}

@Preview
@Composable
fun ProductFormScreenPreview() = ProductFormScreen(
    viewModel = ProductFormScreenViewModel(),
    onSaveClick = {}
)
