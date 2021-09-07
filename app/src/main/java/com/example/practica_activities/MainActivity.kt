package com.example.practica_activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.practica_activities.Image.Companion.images
import androidx.constraintlayout.widget.*
import android.content.Intent
import android.content.SharedPreferences
import com.squareup.moshi.Moshi


class MainActivity : AppCompatActivity() {

    companion object {
        var doLogout = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initView()

    }


    private lateinit var clMenuImage: ConstraintLayout
    private lateinit var imageSelect: ImageView
    private lateinit var btnLeft: ImageView
    private lateinit var btnRight: ImageView
    private lateinit var btnMoreInfo: Button

    var inum: Int = 0

    private fun initView(){
        clMenuImage = findViewById(R.id.clMenuImage)
        imageSelect = findViewById(R.id.imageSelect)
        btnLeft = findViewById(R.id.btnLeft)
        btnRight = findViewById(R.id.btnRight)
        btnMoreInfo = findViewById(R.id.btnMoreInfo)

        imageSelect.setImageResource(images[inum].imageSrc!!.resource)

        btnRight.setOnClickListener{
            next()
        }

        btnLeft.setOnClickListener{
            previous()
        }
        btnMoreInfo.setOnClickListener {
            val intent = Intent(this, Selected_Image::class.java).apply{
                putExtra("adobeSelected", inum.toString())
            }
            startActivity(intent)
        }
    }

    private fun next(){
        when(inum){
            in 0..8 ->
            {
                inum++
                imageSelect.setImageResource(images[inum].imageSrc!!.resource)

            }
         else ->
         {
             inum = 0
         }
        }
    }

    private fun previous(){
        when(inum){
            in 1..9 ->
            {
                inum--
                imageSelect.setImageResource(images[inum].imageSrc!!.resource)
            }
            else ->
            {
                inum = 9
            }
        }
    }

}
