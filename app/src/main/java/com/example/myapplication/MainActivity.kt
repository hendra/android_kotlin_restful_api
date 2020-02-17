package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    // Trailing slash is needed
    val BASE_URL : String = "https://testapi-app.herokuapp.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val service = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(SampleService::class.java)

        // Get all books
        // GET /books.json
        service.getBooks()
            .enqueue(object : Callback<List<Book>> {
                override fun onResponse(call: Call<List<BookResponse>>, response: Response<List<BookResponse>>) {
                    response.body()?.forEach { println("TAG_: ${it}") }
                    println(response.body())
                }

                override fun onFailure(call: Call<List<BookResponse>>, t: Throwable) = t.printStackTrace()
            })

        // Get a book by id
        // GET /books/1.json
//        service.getBook(2)
//            .enqueue(object : Callback<Book> {
//                override fun onResponse(call: Call<Book>, response: Response<Book>) {
//                    println("TAG_: ${response.body()}")
//                }
//
//                override fun onFailure(call: Call<Book>, t: Throwable) = t.printStackTrace()
//            })

        // Create book
        // GET /books.json
//        service.addBook("Title 1", "Author 1")
//            .enqueue(object : Callback<Book> {
//                override fun onResponse(call: Call<Book>, response: Response<Book>) {
//                    println("TAG_: ${response.body()}")
//                }
//
//                override fun onFailure(call: Call<Book>, t: Throwable) = t.printStackTrace()
//            })

        // Update book
        // PATCH /books.json
//        service.updateBook(17,"Title 3", "Author 1")
//            .enqueue(object : Callback<Book> {
//                override fun onResponse(call: Call<Book>, response: Response<Book>) {
//                    println("TAG_: ${response.body()}")
//                }
//
//                override fun onFailure(call: Call<Book>, t: Throwable) = t.printStackTrace()
//            })

        // Delete book
        // DELETE /books.json
//        service.deleteBook(2)
//            .enqueue(object : Callback<Book> {
//                override fun onResponse(call: Call<Book>, response: Response<Book>) {
//                    println("TAG_: ${response.code()}")
//                }
//
//                override fun onFailure(call: Call<Book>, t: Throwable) = t.printStackTrace()
//            })
    }
}
