package com.example.wikipedia

import com.example.wikipedia.data.ItemPost

interface ItemEvent {

    fun onItemClicked(itemPost : ItemPost){

    }
}