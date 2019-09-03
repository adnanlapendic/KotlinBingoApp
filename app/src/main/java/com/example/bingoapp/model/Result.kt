package com.example.bingoapp.model


import com.google.gson.annotations.SerializedName

data class Result(
    val geometry: Geometry,
    val icon: String,
    val id: String,
    val name: String,
    @SerializedName("opening_hours")
    val openingHours: OpeningHours,
    val photos: List<Photo>,
    @SerializedName("place_id")
    val placeId: String,
    @SerializedName("plus_code")
    val plusCode: PlusCode,
    @SerializedName("price_level")
    val priceLevel: Double,
    val rating: Double,
    val reference: String,
    val scope: String,
    val types: List<String>,
    @SerializedName("user_ratings_total")
    val userRatingsTotal: Double,
    val vicinity: String
)