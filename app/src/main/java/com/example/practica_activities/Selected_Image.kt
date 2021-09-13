package com.example.practica_activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.SharedPreferences
import android.widget.ImageView
import android.widget.TextView
import com.example.practica_activities.Image.Companion.images
import androidx.constraintlayout.widget.*
import com.squareup.moshi.Moshi




class Selected_Image : AppCompatActivity() {

    private val MY_PREFERENCES = "MY_PREFERENCES"
    private val ADOBE_PREFS = "ADOBE_PREFS"
    private lateinit var preferences: SharedPreferences
    private val moshi = Moshi.Builder().build()
    private lateinit var objImage: Image

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selected_image)

        preferences = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE)

        val intent = intent
        val str = intent.getStringExtra("adobeSelected")
        val imSelect: Int = Integer.parseInt(str)

        objImage = getImage()

        initView(imSelect)


            if(objImage.imageSrc == images[imSelect].imageSrc) {

                objImage.star = Star.STAR
                star.setImageResource(objImage.star!!.sta)
            }
            else
            {
                objImage.star = Star.NOSTAR
                star.setImageResource(objImage.star!!.sta)
            }


        imageSelected.setImageResource(images[imSelect].imageSrc!!.resource)
        desTxt.setHint(images[imSelect].des!!.txt)
       //star.setImageResource(images[imSelect].star!!.sta)
    }


    private lateinit var clSelectImage: ConstraintLayout
    private lateinit var imageSelected: ImageView
    private lateinit var desTxt: TextView
    private lateinit var star: ImageView


    private fun initView(i: Int){
        clSelectImage = findViewById(R.id.clSelectImage)
        imageSelected = findViewById(R.id.imageSelected)
        desTxt = findViewById(R.id.DesTxt)
        star = findViewById(R.id.Star)
        //var starOrn = false

        star.setOnClickListener{
            saveImage(images[i])
            images[i].star = Star.STAR
            star.setImageResource(images[i].star!!.sta)
            /*if(starOrn){
                images[i].star = Star.NOSTAR
                star.setImageResource(images[i].star!!.sta)
            } else{
                images[i].star = Star.STAR
                star.setImageResource(images[i].star!!.sta)
            }
            starOrn = !starOrn*/
        }

        imageSelected.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java).apply{
                putExtra("adobeSelected", i.toString())
            }
            startActivity(intent)
        }
    }

    private fun saveImage(image: Image) {
        preferences.edit().putString("ADOBE_PREFS",moshi.adapter(Image::class.java).toJson(image)).apply()

    }

    private fun getImage() =
        preferences.getString("ADOBE_PREFS", null)?.let {
            return@let try {
                moshi.adapter(Image::class.java).fromJson(it)
            } catch (e: Exception) {
                Image()
            }
        } ?: Image()

}