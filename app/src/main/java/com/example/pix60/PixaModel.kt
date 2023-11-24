package com.example.pix60

data class PixaModel(
    val hits: List<ImageModel>
)
data class ImageModel(
    val largeImageUrl: String
)
