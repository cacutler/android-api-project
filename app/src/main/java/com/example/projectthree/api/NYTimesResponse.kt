package com.example.projectthree.api
import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class NYTimesResponse (val results: BookResponse)