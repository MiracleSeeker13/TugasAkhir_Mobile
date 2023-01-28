package com.example.tugasakhir.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BukuResponse (
    @Expose
    @SerializedName("code")
    val code: Int,
    @Expose
    @SerializedName("errors")
    val errors: Any,
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("data")
    val data: ArrayList<BukuDataResponse>?
    )