package com.example.bingoapp.model


import com.google.gson.annotations.SerializedName

data class Viewport(
    val northeast: Northeast,
    val southwest: Southwest
)