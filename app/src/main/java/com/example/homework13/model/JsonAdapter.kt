package com.example.homework13.model

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson


object JsonAdapter {
    @FromJson
    @IdQualifier
    fun fromJson(idIndeterminate: IdIntermediate): Id {
        return idIndeterminate.id?.let { Id(idIndeterminate.id) }
            ?: idIndeterminate.pk?.let { Id(idIndeterminate.pk) } ?: Id(null)
    }
    @ToJson
    fun toJson(@IdQualifier id: Id): IdIntermediate {
        return IdIntermediate(id = id.id, pk = null)
    }
}