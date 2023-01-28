package com.example.tugasakhir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment

class DetailBukuFragment : Fragment() {
    private lateinit var edtKodeBuku: EditText
    private lateinit var edtJudul: EditText
    private lateinit var edtEdisi: EditText
    private lateinit var edtISBN: EditText
    private lateinit var edtPengarang: EditText
    private lateinit var edtPenerbit: EditText
    private lateinit var edtTahunTerbit: EditText
    private lateinit var edtTempatTerbit: EditText
    private lateinit var edtBahasa: EditText
    private lateinit var edtSubjek: EditText
    private lateinit var edtJumlah: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edtKodeBuku = view.findViewById(R.id.edt_kode_buku)
        edtJudul = view.findViewById(R.id.edt_judul)
        edtEdisi = view.findViewById(R.id.edt_edisi)
        edtISBN = view.findViewById(R.id.edt_isbn)
        edtPengarang = view.findViewById(R.id.edt_pengarang)
        edtPenerbit = view.findViewById(R.id.edt_penerbit)
        edtTahunTerbit = view.findViewById(R.id.edt_tahun_terbit)
        edtTempatTerbit = view.findViewById(R.id.edt_tempat_terbit)
        edtBahasa = view.findViewById(R.id.edt_bahasa)
        edtSubjek = view.findViewById(R.id.edt_subjek)
        edtJumlah = view.findViewById(R.id.edt_jumlah)

        if (arguments != null) {
            val kode_buku = arguments?.getString("kode_buku")
            val judul = arguments?.getString("judul")
            val edisi = arguments?.getString("edisi")
            val isbn = arguments?.getString("ISBN")
            val pengarang = arguments?.getString("pengarang")
            val penerbit = arguments?.getString("penerbit")
            val tahun_terbit = arguments?.getString("tahun_terbit")
            val tempat_terbit = arguments?.getString("tempat_terbit")
            val bahasa = arguments?.getString("bahasa")
            val subjek = arguments?.getString("subjek")
            val jumlah = arguments?.getString("jumlah")

            edtKodeBuku.setText(kode_buku)
            edtJudul.setText(judul)
            edtEdisi.setText(edisi)
            edtISBN.setText(isbn)
            edtPengarang.setText(pengarang)
            edtPenerbit.setText(penerbit)
            edtTahunTerbit.setText(tahun_terbit)
            edtTempatTerbit.setText(tempat_terbit)
            edtBahasa.setText(bahasa)
            edtSubjek.setText(subjek)
            edtJumlah.setText(jumlah)
        }
    }


}