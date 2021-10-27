package com.example.homework13.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IdIntermediate(
    @Json(name = "id") val id: Int?,
    @Json(name = "pk") val pk: Int?
)