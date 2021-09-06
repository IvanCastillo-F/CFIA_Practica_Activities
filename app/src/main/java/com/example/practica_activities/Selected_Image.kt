package com.example.practica_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import com.example.practica_activities.Image.Companion.images
import androidx.constraintlayout.widget.*




class Selected_Image : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selected_image)

        initView()

        val intent = intent
        val str = intent.getStringExtra("adobeSelected")
        var ImSelect: Int = Integer.parseInt(str)

        imageSelected.setImageResource(images[ImSelect].imageSrc!!.resource)
        desTxt.setHint(images[ImSelect].des!!.txt)
        star.setImageResource(images[ImSelect].star!!.sta)
    }

    private lateinit var clSelectImage: ConstraintLayout
    private lateinit var imageSelected: ImageView
    private lateinit var desTxt: TextView
    private lateinit var star: ImageView

    private fun initView(){
        clSelectImage = findViewById(R.id.clSelectImage)
        imageSelected = findViewById(R.id.imageSelected)
        desTxt = findViewById(R.id.DesTxt)
        star = findViewById(R.id.Star)
    }
}