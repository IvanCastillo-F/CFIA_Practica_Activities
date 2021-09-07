package com.example.practica_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent = intent
        val str = intent.getStringExtra("adobeSelected")
        var imSelect: Int = Integer.parseInt(str)
        initView()
        adobeImage.setImageResource(Image.images[imSelect].imageSrc!!.resource)
    }
    private lateinit var clBigImage: ConstraintLayout
    private lateinit var adobeImage: ImageView

    private fun initView(){
        clBigImage = findViewById(R.id.clBigImage)
        adobeImage = findViewById(R.id.adobeImage)
    }
}