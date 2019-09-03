package com.example.bingoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bingoapp.R
import com.example.bingoapp.api.BingoInterface
import com.example.bingoapp.api.PlacesClient
import com.example.bingoapp.model.Bingo
import com.example.bingoapp.repository.BingoRepository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var repository: BingoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bingoService: BingoInterface = PlacesClient.getBingoSupermarkets()

        repository = BingoRepository(bingoService)

        viewModel = getViewModel()

        viewModel.listOfBingoSupermakets.observe(this, Observer {
            bindUI(it)
        })

    }

     private fun bindUI(it: List<Bingo>) {

         Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()

         val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
         recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

         val adapter = BingoAdapter(it)
         recyclerView.adapter = adapter
    }

    private fun getViewModel(): MainViewModel {

        return ViewModelProviders.of(this, object: ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        })[MainViewModel::class.java]

    }

}
