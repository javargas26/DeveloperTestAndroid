package com.example.developertest2

import retrofit2.Call
import retrofit2.http.GET

interface ApiService{

    @GET ("/posts")
    fun fetchAllPosts(): Call<List<Post>>
}