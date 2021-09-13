package com.example.practica_activities

import android.media.MediaPlayer
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import com.example.practica_activities.Image.Companion.images
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.practica_activities.R.layout.activity_main
import androidx.fragment.app.FragmentTransaction


class MainActivity_Fragment : Fragment(R.layout.fragment_main_activity_) {


    private val KEY = "STATE_KEY"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_main_activity_, container, false);


        initView(view)

        fun playSound(sound: Int){
            var mp = MediaPlayer.create(getActivity(), sound);
            mp.start()
        }
        btnMoreInfo.setOnClickListener {
            replaceFragment(Image_Selected_Fragment().apply {
                arguments = Bundle().apply {
                    putString("key", inum.toString())
                }
            })

            images[inum].sound?.let { it1 -> playSound(it1) }
        }
        return view
    }

    private lateinit var clMenuImage: ConstraintLayout
    private lateinit var imageSelect: ImageView
    private lateinit var btnLeft: ImageView
    private lateinit var btnRight: ImageView
    private lateinit var btnMoreInfo: Button

    var inum: Int = 0

    private fun initView(view: View){
        clMenuImage = view.findViewById(R.id.clMenuImage)
        imageSelect = view.findViewById(R.id.imageSelect)
        btnLeft = view.findViewById(R.id.btnLeft)
        btnRight = view.findViewById(R.id.btnRight)
        btnMoreInfo = view.findViewById(R.id.btnMoreInfo)
        imageSelect.setImageResource(Image.images[inum].imageSrc!!.resource)




        btnRight.setOnClickListener{
            next()
        }

        btnLeft.setOnClickListener{
            previous()
        }

    }

    private fun next(){
        when(inum){
            in 0..8 ->
            {
                inum++
                imageSelect.setImageResource(Image.images[inum].imageSrc!!.resource)

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
                imageSelect.setImageResource(Image.images[inum].imageSrc!!.resource)
            }
            else ->
            {
                inum = 9
            }
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

}