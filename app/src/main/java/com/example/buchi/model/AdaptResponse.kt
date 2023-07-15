package com.example.buchi.model

import kotlinx.serialization.Serializable

@Serializable
data class AdaptResponse(
    val status :String,
    val customer_id:String
)