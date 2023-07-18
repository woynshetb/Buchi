package com.example.buchi.model

import kotlinx.serialization.Serializable

@Serializable
data class Pet(
    val type :String,
    val gender :String,
    val size :String,
    val age :String,
    var good_with_children:Boolean,
    var source:String,
    val photos: List<PhotoData>
)