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
import android.media.MediaPlayer
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.moshi.Moshi


class MainActivity : AppCompatActivity() {

    companion object {
        var doLogout = false
    }
    private val KEY = "STATE_KEY"
    private lateinit var initTxt: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


            replaceFragment(MainActivity_Fragment().apply {
                arguments = Bundle().apply {
                    putString("key", "This is main fragment")

                }
            })


    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putBoolean(KEY, false)
        }

        super.onSaveInstanceState(outState)
    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
            replace(R.id.container, fragment)
            addToBackStack(fragment.tag)
            commit()
        }
    }

}
