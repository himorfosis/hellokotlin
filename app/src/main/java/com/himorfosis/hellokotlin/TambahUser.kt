package com.himorfosis.hellokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

class TambahUser : AppCompatActivity() {

//    val nama, ttl, goldar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tambah_user)

        val nama = findViewById(R.id.nama) as TextView
        val ttl = findViewById(R.id.ttl) as TextView
        val goldar = findViewById(R.id.goldar) as TextView
        val tambah = findViewById(R.id.tambah) as Button

//        tambah.setOnClickListener(View.OnClickListener {
//
//            alert { "tambah user" }
//
//        })

        tambah.setOnClickListener { view ->

            alert("Tambah User") {

                yesButton { toast("data ditambah") }
                noButton {  }

            }.show()

        }

    }
}
