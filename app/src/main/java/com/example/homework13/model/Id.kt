package com.example.homework13.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Id(val id: Int?)