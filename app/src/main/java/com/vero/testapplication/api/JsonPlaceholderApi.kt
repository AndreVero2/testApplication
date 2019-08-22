package com.vero.testapplication.api

import com.vero.testapplication.entities.Post
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
        fun getApi(): JsonPlaceholderApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(JsonPlaceholderApi::class.java)

        }

    }
