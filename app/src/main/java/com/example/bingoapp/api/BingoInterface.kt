package com.example.bingoapp.api

import com.example.bingoapp.model.Bingo
import io.reactivex.Single
import retrofit2.http.GET

interface BingoInterface {
    @GET("json?location=44.535942,18.679043&radius=3000&type=point_of_interest&keyword=bingo&key=AIzaSyBOe-I5hE4tkNMNEMx0uQ002BJyLJykwYk")
    fun getAllBingoSupermarkets() : Single<Bingo>
}