package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface SampleService {
    @GET("books.json")
    fun getBooks(): Call<List<Book>>
}