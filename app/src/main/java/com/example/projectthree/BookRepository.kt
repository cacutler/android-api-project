package com.example.projectthree
import com.example.projectthree.api.BookBestSellerApi
import com.example.projectthree.api.ListItem
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
class BookRepository {
    private val bookBestSellerApi: BookBestSellerApi
    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.nytimes.com/").addConverterFactory(MoshiConverterFactory.create()).build()
        bookBestSellerApi = retrofit.create()
    }
    suspend fun fetchBooks(): List<ListItem> = bookBestSellerApi.fetchBooks().results.listItems
}