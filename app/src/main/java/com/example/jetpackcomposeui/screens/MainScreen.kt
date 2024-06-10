package com.example.jetpackcomposeui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.jetpackcomposeui.model.ProductItem
import com.example.jetpackcomposeui.viewmodel.ViewModel

@Composable
fun MainScreen(viewModel: ViewModel = hiltViewModel()) {
    val products by viewModel.products.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            items(products) { productItem: ProductItem ->
                ProductCard(productItem = productItem)
            }
        }
    }
}

@Composable
fun ProductCard(productItem: ProductItem) {
    val image = rememberAsyncImagePainter(model = productItem.image)
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()

    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = productItem.title,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = productItem.description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    MainScreen()
}