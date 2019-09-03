package com.example.bingoapp.api

import com.example.bingoapp.model.Bingo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BingoInterface {
//    @GET("json?input=bingo&inputtype=textquery&fields=photos,formatted_address,name,opening_hours,rating&locationbias=circle:3000@44.535942,18.679043&key=AIzaSyBOe-I5hE4tkNMNEMx0uQ002BJyLJykwYk")
    @GET("json?input=bingo&inputtype=textquery&fields=photos,formatted_address,name,opening_hours,rating&locationbias=circle:3000@44.535942,18.679043&key=AIzaSyBOe-I5hE4tkNMNEMx0uQ002BJyLJykwYk")
    fun getAllBingoSupermarkets() : Single<List<Bingo>>
}