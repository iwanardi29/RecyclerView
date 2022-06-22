package com.iwanardianto.recyclerview.adapter

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iwanardianto.recyclerview.databinding.ListItemPemainBinding
import com.iwanardianto.recyclerview.model.Pemain

class AdapterTeamBola(private val context: Context,
                      private val data:List<Pemain>?,
                      private val itemclick : OnClickListener)
    : RecyclerView.Adapter<AdapterTeamBola.Viewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val binding = ListItemPemainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val  item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama

        holder.itemView.setOnClickListener {
            itemclick.detailData(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?:0

    inner class Viewholder(val binding : ListItemPemainBinding) : RecyclerView.ViewHolder(binding.root){
        var foto =  binding.image
        var nama = binding.txtnama

    }

    interface OnClickListener{
        fun detailData(item : Pemain?)
    }

}