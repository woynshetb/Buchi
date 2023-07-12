package com.example.buchi.model

import kotlinx.serialization.Serializable

@Serializable
data class PetData(
    val status :String,
    val pets:List<Pet>
)