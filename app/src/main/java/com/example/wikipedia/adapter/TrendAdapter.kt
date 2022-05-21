package com.example.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.ItemEvent
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.TrendFragmentBinding
import com.example.wikipedia.databinding.TrendItemBinding

class TrendAdapter(val data: ArrayList<ItemPost>, val itemEvent: ItemEvent) :
    RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {

    lateinit var binding: TrendItemBinding

    inner class TrendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(itemPost : ItemPost){

            Glide.with(binding.root).load(itemPost.imgUrl).into(binding.imgTrendMain)

            binding.txtTrendTitle.text = itemPost.txtTitle

            binding.txtTrendSubtitle.text = itemPost.txtSubtitile

            binding.txtTrendInsight.text = itemPost.inSight

            binding.txtTrendNumber.text = (adapterPosition + 1).toString()

            itemView.setOnClickListener{

                itemEvent.onItemClicked(itemPost)
            }




        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {

        binding = TrendItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TrendViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {


        holder.bindViews(data[position])
    }

    override fun getItemCount(): Int {


        return data.size
    }
}