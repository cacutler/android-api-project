package com.example.projectthree.api
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class BookResponse (@Json(name = "books") val listItems: List<ListItem>)