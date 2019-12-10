package com.example.developertest2

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Post(
    @SerializedName("userId") val userId: Int = 0,
    @SerializedName("id") val id: Int = 0,
    @SerializedName("title") val title: String? = null,
    @SerializedName("body") val body: String? = null

) : Serializable