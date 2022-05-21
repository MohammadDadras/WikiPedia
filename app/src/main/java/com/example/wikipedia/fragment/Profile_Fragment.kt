package com.example.wikipedia.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wikipedia.R
import com.example.wikipedia.databinding.ExploreFragmentBinding
import com.example.wikipedia.databinding.ProfileFragmentBinding
import com.google.android.material.card.MaterialCardView

class Profile_Fragment : Fragment() {


    lateinit var binding : ProfileFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ProfileFragmentBinding.inflate(layoutInflater,container,false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val card = view.findViewById<MaterialCardView>(R.id.mainCard)
//
//        card.isChecked = true
    }
}