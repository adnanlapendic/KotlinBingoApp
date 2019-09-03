package com.example.bingoapp.model


import com.google.gson.annotations.SerializedName

data class Photo(
    val height: Double,
    @SerializedName("html_attributions")
    val htmlAttributions: List<String>,
    @SerializedName("photo_reference")
    val photoReference: String,
    val width: Double
)