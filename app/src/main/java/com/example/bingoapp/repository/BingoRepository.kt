package com.example.bingoapp.repository

import androidx.lifecycle.LiveData
import com.example.bingoapp.api.BingoInterface
import com.example.bingoapp.model.Bingo
import io.reactivex.disposables.CompositeDisposable

class BingoRepository (private val bingoService: BingoInterface) {
    lateinit var networkDataSource: NetworkDataSource

    fun getAllBingoSupermarkets(compositeDisposable: CompositeDisposable): LiveData<Bingo> {
        networkDataSource = NetworkDataSource(bingoService, compositeDisposable)
        networkDataSource.getAllBingoSupermarkets()

        return networkDataSource.downloadedResponse
    }
}