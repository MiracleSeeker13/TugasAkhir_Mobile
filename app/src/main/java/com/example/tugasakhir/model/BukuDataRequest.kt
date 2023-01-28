package com.example.tugasakhir.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BukuDataRequest (
    @Expose
    @SerializedName("kode_buku")
    val Kode_buku: String,
    @Expose
    @SerializedName("judul")
    val Judul: String,
    @Expose
    @SerializedName("edisi")
    val Edisi: String,
    @Expose
    @SerializedName("ISBN")
    val ISBN: String,
    @Expose
    @SerializedName("pengarang")
    val Pengarang: String,
    @Expose
    @SerializedName("penerbit")
    val Penerbit: String,
    @Expose
    @SerializedName("tahun_terbit")
    val Tahun_terbit: String,
    @Expose
    @SerializedName("tempat_terbit")
    val Tempat_terbit: String,
    @Expose
    @SerializedName("bahasa")
    val Bahasa: String,
    @Expose
    @SerializedName("subjek")
    val Subjek: String,
    @Expose
    @SerializedName("jumlah")
    val Jumlah: String,
    @Expose
    @SerializedName("cover")
    val Cover: String
    )