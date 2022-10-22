package com.maximus.task.Retrofit

import com.google.gson.annotations.SerializedName

data class Fact(
    @SerializedName("fact")
    val fact: String? = null,

    @SerializedName("length")
    val length: Int? = null
)
