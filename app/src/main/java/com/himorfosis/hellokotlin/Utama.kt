package com.himorfosis.hellokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.Toast
import com.himorfosis.hellokotlin.R.attr.layoutManager
import kotlinx.android.synthetic.main.utama.*
import org.jetbrains.anko.toast


class Utama : AppCompatActivity(), HeroListener {

//    val data : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.utama)

        val tambah = findViewById<FloatingActionButton>(R.id.tambah)

        identitasAdapter()

        tambah.setOnClickListener { view ->
//            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                .setAction("Action", null)
//                .show()

            toast("hello kotlin")

            startActivity(Intent(this@Utama, TambahUser::class.java))

        }

    }

    override fun onHeroClick(hero: IdentitasClassData) {
        Toast.makeText(this, "${hero.name}", Toast.LENGTH_SHORT).show()
    }

    private fun identitasAdapter() {

        //getting recyclerview from xml
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        //crating an arraylist to store users using the data class user
        val users = ArrayList<IdentitasClassData>()

        //adding some dummy data to the list
        users.add(IdentitasClassData("Belal Khan", "https://i.annihil.us/u/prod/marvel/i/mg/9/30/538cd33e15ab7/standard_xlarge.jpg"))
        users.add(IdentitasClassData("Ramiz Khan", "https://i.annihil.us/u/prod/marvel/i/mg/1/c0/537ba2bfd6bab/standard_xlarge.jpg"))
        users.add(IdentitasClassData("Faiz Khan", "https://i.annihil.us/u/prod/marvel/i/mg/1/c0/537ba2bfd6bab/standard_xlarge.jpg"))
        users.add(IdentitasClassData("Yashar Khan", "https://i.annihil.us/u/prod/marvel/i/mg/1/c0/537ba2bfd6bab/standard_xlarge.jpg"))

        //creating our adapter
        val adapter = IdentitasAdapter(users)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter

    }

    private fun utamaAdapter() {

        val listData = listOf(
            IdentitasClassData(name = "Spider-Man",  image = "https://i.annihil.us/u/prod/marvel/i/mg/9/30/538cd33e15ab7/standard_xlarge.jpg"),
            IdentitasClassData(name = "Bat-Man", image = "https://i.annihil.us/u/prod/marvel/i/mg/1/c0/537ba2bfd6bab/standard_xlarge.jpg"),
            IdentitasClassData(name = "Super-Man",  image ="https://i.annihil.us/u/prod/marvel/i/mg/6/a0/55b6a25e654e6/standard_xlarge.jpg"),
            IdentitasClassData(name = "X-Man",  image ="https://i.annihil.us/u/prod/marvel/i/mg/5/c0/537ba730e05e0/standard_xlarge.jpg"),
            IdentitasClassData(name = "Ant-Man",  image ="https://i.annihil.us/u/prod/marvel/i/mg/9/30/538cd33e15ab7/standard_xlarge.jpg"),
            IdentitasClassData(name = "Cat-Man", image = "https://i.annihil.us/u/prod/marvel/i/mg/9/30/538cd33e15ab7/standard_xlarge.jpg")
        )

        val adapterIdentitas = UtamaAdapter(listData, this)

        recyclerView.apply {

            layoutManager = LinearLayoutManager(this@Utama)
            adapter = adapterIdentitas
        }


    }

}
