package com.example.bingoapp.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bingoapp.R
import com.example.bingoapp.model.Result

class BingoAdapter(private val listOfBingoSupermarkets:List<Result>) : RecyclerView.Adapter<BingoAdapter.ViewHolder>() {

    lateinit var thisContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            thisContext = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bingo_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfBingoSupermarkets.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val bingo = listOfBingoSupermarkets[position]

        holder.bingoName.text = bingo.name
        holder.bingoAddress.text = bingo.vicinity

        holder.itemView.setOnClickListener{
            val intent = Intent(thisContext, MapsActivity::class.java)
            intent.putExtra("latitude", bingo.geometry.location.lat)
            intent.putExtra("longitude", bingo.geometry.location.lng)
            intent.putExtra("address", bingo.vicinity)
            this.thisContext.startActivity(intent)
        }

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val bingoName = itemView.findViewById<TextView>(R.id.bingo_name)
        val bingoAddress = itemView.findViewById<TextView>(R.id.bingo_address)
    }

}

