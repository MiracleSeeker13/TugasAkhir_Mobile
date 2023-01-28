package com.example.tugasakhir.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasakhir.R
import com.example.tugasakhir.model.BukuDataResponse

internal class BukuAdapter(private val bukuList: ArrayList<BukuDataResponse>, private val listener : onAdapterListener)
    : RecyclerView.Adapter<BukuAdapter.MyViewHolder>(){
    internal inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var judul: TextView = view.findViewById(R.id.txt_judul)
        val cv_container_Menu= view.findViewById<CardView>(R.id.id_cv_container_Menu_Grid)

        fun bindHolder(buku : BukuDataResponse){
            judul.text = buku.Judul

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.grid_layout_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position:Int){
        holder.bindHolder(bukuList[position])
        val buku = bukuList[position]
        holder.cv_container_Menu.setOnClickListener{
            Log.e ("buku", bukuList[position].Kode_buku)
            listener.onClick(buku.Kode_buku,buku.Judul, buku.Edisi, buku.ISBN, buku.Pengarang, buku.Penerbit, buku.Tahun_terbit,
                buku.Tempat_terbit, buku.Bahasa, buku.Subjek, buku.Jumlah
            )
        }
    }
    override fun getItemCount():Int {
        return bukuList.size
    }

    fun searchDataList(searchList: ArrayList<BukuDataResponse>) {
        bukuList.clear()
        bukuList.addAll(searchList)
        notifyDataSetChanged()
    }

    fun setData(data : ArrayList<BukuDataResponse>){
        bukuList.clear()
        bukuList.addAll(data)
        notifyDataSetChanged()
    }
    interface onAdapterListener {
        fun onClick(
            Kode_buku: String, Judul: String, Edisi: String, ISBN: String, Pengarang: String, Penerbit: String,
            Tahun_terbit: String, Tempat_terbit: String, Bahasa: String, Subjek: String, Jumlah: String)
    }
}