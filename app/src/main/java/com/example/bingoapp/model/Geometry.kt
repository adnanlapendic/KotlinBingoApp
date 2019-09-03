package com.example.bingoapp.model


import com.google.gson.annotations.SerializedName

data class Geometry(
    val location: Location,
    val viewport: Viewport
)