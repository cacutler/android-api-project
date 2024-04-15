package com.example.projectthree.api
import retrofit2.http.GET
private const val API_KEY = "S1SVy4FkkhTStn2st3AKSIGKRcsFts6p"
interface BookBestSellerApi {
    @GET("svc/books/v3/lists/current/hardcover-fiction.json?api-key=$API_KEY")
    suspend fun fetchBooks(): NYTimesResponse
}