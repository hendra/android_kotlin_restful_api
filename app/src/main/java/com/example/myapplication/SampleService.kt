package com.example.myapplication

import retrofit2.Call
import retrofit2.http.*

interface SampleService {
    // GET /books
    @GET("books.json")
    fun getBooks(): Call<List<Book>>

    // GET /books/{id}
    @GET("books/{id}.json")
    fun getBook(@Path("id") id:Int): Call<Book>

    // POST /books
    @FormUrlEncoded
    @POST("books.json")
    fun addBook(
        @Field("book[title]") title: String?,
        @Field("book[author]") body: String?
    ): Call<Book>

    // PATCH /books
    @FormUrlEncoded
    @PATCH("books/{id}.json")
    fun updateBook(
        @Path("id") id:Int,
        @Field("book[title]") title: String?,
        @Field("book[author]") body: String?
    ): Call<Book>

    // DELETE /books/{id}
    @DELETE("books/{id}.json")
    fun deleteBook(@Path("id") id:Int): Call<Book>
}