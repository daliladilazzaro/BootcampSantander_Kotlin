package com.example.testecomapi

import com.google.gson.annotations.SerializedName

data class Product (@SerializedName("id") val id:String,@SerializedName("prName") val prName:String,
                    @SerializedName("prImage") val prImage:String,@SerializedName("prPrice") val prPrice:String)