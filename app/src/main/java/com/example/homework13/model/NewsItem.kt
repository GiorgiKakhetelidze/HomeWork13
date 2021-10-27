package com.example.homework13.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.JsonQualifier

@Target(AnnotationTarget.TYPE, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.FUNCTION
)
@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class IdQualifier

@JsonClass(generateAdapter = true)
data class NewsItem(
    @Json(name = "created_at")
    val createdAt: Any?,
    @Json(name = "date")
    val date: String,
    @Json(name = "deleted_at")
    val deletedAt: Any?,
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    @IdQualifier val id: Id,
    @Json(name = "images")
    val images: String?,
    @Json(name = "img-url")
    val imgUrl: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "updated_at")
    val updatedAt: Any?
)