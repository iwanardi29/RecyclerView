package com.iwanardianto.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.iwanardianto.recyclerview.adapter.AdapterTeamBola
import com.iwanardianto.recyclerview.databinding.ActivityMainBinding
import com.iwanardianto.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Thibaut Courtois",R.drawable.courtois,"Penjaga Gawang","2.00 m","Bree(Belgia)","11 Mei 1992"))
        listPemain.add(Pemain("Karim Benzema",R.drawable.benzema,"Penyerang","1.85 m","Lyon(Perancis)","19 Desember 1987"))
        listPemain.add(Pemain("Marcelo Vieira da Silva",R.drawable.marcello,"Belakang","1.74 m","Rio De Janiero(Brazil)","12 Mei 1988"))
        listPemain.add(Pemain("Sergio Ramos García",R.drawable.ramos,"Belakang","1.84 m","Camas(Sevilla)","30 Maret 1986"))
        listPemain.add(Pemain("Zinedine Yazid Zidane",R.drawable.zidan,"Pelatih","1.85 m","Marseille(Perancis)","23 Juni 1972"))

        binding.list.adapter = AdapterTeamBola(this,listPemain,object : AdapterTeamBola.OnClickListener{
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txt_nama_pemain)
                    val posisi = this.findViewById<TextView>(R.id.txt_posisi)
                    val tinggi = this.findViewById<TextView>(R.id.txt_tinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txt_tempat_lahir)
                    val  tgllahir = this.findViewById<TextView>(R.id.txt_tanggal_lahir)
                    val btn = this.findViewById<Button>(R.id.btnclose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatLahir}"
                    tgllahir.text = "${item?.tglLahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }

                }.show()
            }

        })
    }
}