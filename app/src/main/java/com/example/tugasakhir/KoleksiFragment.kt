package com.example.tugasakhir

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasakhir.adapter.BukuAdapter
import com.example.tugasakhir.model.BukuDataResponse
import com.example.tugasakhir.model.BukuResponse
import com.example.tugasakhir.service.BukuService
import com.example.tugasakhir.util.Retro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class KoleksiFragment : Fragment(){
    private lateinit var rv_Menu : RecyclerView
    private lateinit var BukuAdapter: BukuAdapter
    private lateinit var gridLayoutManager:GridLayoutManager
    private lateinit var arrayList:ArrayList<BukuDataResponse>


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_koleksi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        BukuAdapter = BukuAdapter(arrayListOf(), object : BukuAdapter.onAdapterListener {
            override fun onClick(
                Kode_buku: String,
                Judul: String,
                Edisi: String,
                ISBN: String,
                Pengarang: String,
                Penerbit: String,
                Tahun_terbit: String,
                Tempat_terbit: String,
                Bahasa: String,
                Subjek: String,
                Jumlah: String
            ) {
                val bundle = Bundle()
                bundle.putString("kode_buku", Kode_buku.toString())
                bundle.putString("judul", Judul)
                bundle.putString("edisi", Edisi)
                bundle.putString("ISBN", ISBN)
                bundle.putString("pengarang", Pengarang)
                bundle.putString("penerbit", Penerbit)
                bundle.putString("tahun_terbit", Tahun_terbit)
                bundle.putString("tempat_terbit", Tempat_terbit)
                bundle.putString("bahasa", Bahasa)
                bundle.putString("subjek", Subjek)
                bundle.putString("jumlah", Jumlah)

                val formMenuFragment: Fragment = DetailBukuFragment()
                formMenuFragment.arguments = bundle
                var fr = (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
                fr.replace(R.id.fl_fragment, formMenuFragment)
                fr.commit()
            }
        })
        rv_Menu = view.findViewById(R.id.rv_Menu)
        rv_Menu.setHasFixedSize(true)
        rv_Menu.layoutManager = LinearLayoutManager(activity)
        rv_Menu.adapter = BukuAdapter
        gridLayoutManager = GridLayoutManager(context, 3, LinearLayoutManager.VERTICAL, false)
        rv_Menu.layoutManager = gridLayoutManager
        arrayList = ArrayList()
        getBukuApi()
    }

    fun getBukuApi(){
        val retro = Retro().getRetroClientInstance().create(BukuService::class.java)
        retro.getBuku().enqueue(object : Callback<BukuResponse> {
            override fun onResponse(
                call: Call<BukuResponse>,
                response: Response<BukuResponse>
            ) {
                if (response.isSuccessful) {
                    val buku = response.body()!!
                    BukuAdapter.setData(buku.data!!)
                    Log.e("Kode Buku :", buku.data.toString())
                } else {
                    Log.e("Error Code : ", response.code().toString())
                    Log.e("Error Code : ", response.message().toString())
                }
            }

            override fun onFailure(call: Call<BukuResponse>, t: Throwable){
                Log.e("Failed",t.message.toString())
            }
        }
        )
    }
}
