package com.example.bingoapp.model


import com.google.gson.annotations.SerializedName

data class Bingo(
    @SerializedName("html_attributions")
    val htmlAttributions: List<Any>,
    val results: List<Result>,
    val status: String
)