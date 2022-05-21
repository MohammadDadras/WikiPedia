package com.example.wikipedia.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.ItemEvent
import com.example.wikipedia.MainActivity2
import com.example.wikipedia.R
import com.example.wikipedia.adapter.ExploreAdapter
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ExploreFragmentBinding
import com.example.wikipedia.databinding.PhotographerFragmentBinding

class Photographer_Fragment : Fragment() , ItemEvent {


    lateinit var binding : PhotographerFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = PhotographerFragmentBinding.inflate(layoutInflater,container,false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Glide.with(requireContext()).load(R.drawable.img_photographer).into(binding.imgPhotographer)



    }


}