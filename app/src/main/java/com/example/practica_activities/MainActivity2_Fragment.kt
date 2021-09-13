package com.example.practica_activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class MainActivity2_Fragment : Fragment(R.layout.fragment_main_activity2_) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_main_activity2_, container, false)
        val str = requireArguments().getString("key")
        val imSelect: Int = Integer.parseInt(str)
        lateinit var adobeImage: ImageView
        adobeImage = view.findViewById(R.id.adobeImage)

        adobeImage.setImageResource(Image.images[imSelect].imageSrc!!.resource)

        return view
    }

}