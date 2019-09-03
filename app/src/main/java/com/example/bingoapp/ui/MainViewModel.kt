package com.example.bingoapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bingoapp.model.Bingo
import com.example.bingoapp.repository.BingoRepository
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(private val repository: BingoRepository) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val listOfBingoSupermakets: LiveData<Bingo> = repository.getAllBingoSupermarkets(compositeDisposable)


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}