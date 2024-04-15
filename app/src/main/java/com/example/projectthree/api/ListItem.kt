package com.example.projectthree.api
import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class ListItem(
    val title: String,
    val description: String,
    val author: String,
    val publisher: String
)