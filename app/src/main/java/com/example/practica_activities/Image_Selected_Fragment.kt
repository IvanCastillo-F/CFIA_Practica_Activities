package com.example.practica_activities

import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import com.example.practica_activities.Image.Companion.images
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentTransaction
import com.squareup.moshi.Moshi

class Image_Selected_Fragment : Fragment(R.layout.fragment_image__selected_) {

    private val MY_PREFERENCES = "MY_PREFERENCES"
    private val ADOBE_PREFS = "ADOBE_PREFS"
    private lateinit var preferences: SharedPreferences
    private val moshi = Moshi.Builder().build()
    private lateinit var objImage: Image

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_image__selected_, container, false)
        val str = requireArguments().getString("key")
        val imSelect: Int = Integer.parseInt(str)

       // objImage = getImage()

       /* if(objImage.imageSrc == images[imSelect].imageSrc) {

            objImage.star = Star.STAR
            star.setImageResource(objImage.star!!.sta)
        }
        else
        {
            objImage.star = Star.NOSTAR
            star.setImageResource(objImage.star!!.sta)
        }*/

        initView(imSelect,view)

        imageSelected.setImageResource(images[imSelect].imageSrc!!.resource)
        desTxt.setHint(images[imSelect].des!!.txt)
        star.setImageResource(images[imSelect].star!!.sta)

        return view
    }

    private lateinit var clSelectImage: ConstraintLayout
    private lateinit var imageSelected: ImageView
    private lateinit var desTxt: TextView
    private lateinit var star: ImageView


    private fun initView(i: Int,view: View){
        clSelectImage = view.findViewById(R.id.clSelectImage)
        imageSelected = view.findViewById(R.id.imageSelected)
        desTxt = view.findViewById(R.id.DesTxt)
        star = view.findViewById(R.id.Star)
        var starOrn = false

        star.setOnClickListener{
            /* saveImage(images[i])
             images[i].star = Star.STAR
             star.setImageResource(images[i].star!!.sta)*/
             if(starOrn){
                 images[i].star = Star.NOSTAR
                 star.setImageResource(images[i].star!!.sta)
             } else{
                 images[i].star = Star.STAR
                 star.setImageResource(images[i].star!!.sta)
             }
             starOrn = !starOrn
        }

        imageSelected.setOnClickListener {
            replaceFragment(MainActivity2_Fragment().apply {
                arguments = Bundle().apply {
                    putString("key", i.toString())
                }
            })

        }
    }


    private fun replaceFragment(fragment: Fragment) {
        val someFragment: Fragment = fragment
        val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
        transaction.setCustomAnimations(
            R.anim.slide_in_right,
            R.anim.slide_out_left,
            R.anim.slide_in_left,
            R.anim.slide_out_right)
        transaction.replace(
            R.id.container,
            someFragment
        )

        transaction.addToBackStack(null)

        transaction.commit()
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