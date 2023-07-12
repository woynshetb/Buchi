package com.example.buchi.network
import com.example.buchi.model.PetData
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType







private const val BASE_URL ="http://64.226.105.205:9000"
val json = Json { ignoreUnknownKeys = true }
private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface  BuchiApiService {

    @GET("buchi/pet")
    suspend fun getAllPets(
        @Query("limit") limit:String,
    ): PetData

    @GET("buchi/pet")
    suspend fun getFilteredPets(
        @QueryMap params: Map<String, String>
    ):PetData
}


object BuchiApi {
    val retrofitService : BuchiApiService by lazy {
        retrofit.create(BuchiApiService::class.java)
    }
}
