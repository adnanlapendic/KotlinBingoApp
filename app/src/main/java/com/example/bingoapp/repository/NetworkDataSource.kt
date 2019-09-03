package com.example.bingoapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bingoapp.api.BingoInterface
import com.example.bingoapp.model.Bingo
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class NetworkDataSource(private val bingoService: BingoInterface, private val compositeDisposable: CompositeDisposable) {
    private val _downloadedResponse = MutableLiveData<List<Bingo>>()
    val downloadedResponse: LiveData<List<Bingo>>
    get() = _downloadedResponse

    fun getAllBingoSupermarkets() {
        try {
            compositeDisposable.add(
                bingoService.getAllBingoSupermarkets()
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                        _downloadedResponse.postValue(it)
                        },{
                        Log.e("NetworkDataSource", it.message)
                        })
                    )
        } catch (e: Exception) {
            Log.e("NetworkDataSource", e.message)
        }
    }
}