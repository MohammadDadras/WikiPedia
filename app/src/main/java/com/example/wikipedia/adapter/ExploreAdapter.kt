package com.example.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.ItemEvent
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ExploreFragmentBinding
import com.example.wikipedia.databinding.ExploreItemBinding
import com.example.wikipedia.databinding.ProfileFragmentBinding

class ExploreAdapter(private val data: ArrayList<ItemPost>,val itemEvent: ItemEvent) :
    RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {

    lateinit var binding: ExploreItemBinding

    inner class ExploreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(itemPost: ItemPost) {

            Glide.with(itemView.context).load(itemPost.imgUrl).into(binding.imgExploreMain)

            binding.txtExploreTitle.text = itemPost.txtTitle

            binding.txtExploreSubtitle.text = itemPost.txtSubtitile

            binding.txtExploreDetail.text = itemPost.txtDetail

            itemView.setOnClickListener{

                itemEvent.onItemClicked(itemPost)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {

        binding = ExploreItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false

        )

        return ExploreViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {

        holder.bindViews(data[position])
    }

    override fun getItemCount(): Int {

        return data.size

    }

}