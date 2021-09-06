package com.example.practica_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }


    private lateinit var clMenuImage: ConstraintLayout
    private lateinit var imageSelect: ImageView
    private lateinit var btnLeft: ImageView
    private lateinit var btnRight: ImageView
    private lateinit var btnMoreInfo: Button


    private fun initViews(){
        clMenuImage = findViewById(R.id.clMenuImage)
        imageSelect = findViewById(R.id.imageSelect)
        btnLeft = findViewById(R.id.btnLeft)
        btnRight = findViewById(R.id.btnRight)
        btnMoreInfo = findViewById(R.id.btnMoreInfo)

    }
}