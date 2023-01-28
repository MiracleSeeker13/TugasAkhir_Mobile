package com.example.tugasakhir.service

import com.example.tugasakhir.model.BukuDataRequest
import com.example.tugasakhir.model.BukuResponse
import retrofit2.Call
import retrofit2.http.*

interface BukuService {
    @GET("buku")
    fun getBuku() : Call<BukuResponse>
    @POST("buku")
    fun postBuku(@Body req: BukuDataRequest) : Call<BukuResponse>
    @PUT("buku/{id}")
    fun putBuku(@Path("id") id:Int, @Body req: BukuDataRequest) : Call<BukuResponse>
    @DELETE("buku/{id}")
    fun deleteBuku(@Path("id") id:Int) : Call<BukuResponse>
}