package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("author")
    var author: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("createdAt")
    var created_at: String? = null,

    @SerializedName("updatedAt")
    var updated_at: String? = null
)

data class BookResponse(
    @SerializedName("currentPage")
    var current_page: Int? = null,

    @SerializedName("totalPages")
    var total_pages: Int? = null,

    @SerializedName("totalRecords")
    var total_records: Int? = null,

    @SerializedName("books")
    var books: List<Book>? = null
)