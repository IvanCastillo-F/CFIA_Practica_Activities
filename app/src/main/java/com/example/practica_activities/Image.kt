package com.example.practica_activities

import android.media.MediaActionSound
import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class Image( var imageSrc: ImageList? = null,
             var des: DescipList? = null,
             var star:Star? = Star.NOSTAR,
             var sound: Int? = null,
             var hearth: Int? = null):Parcelable{
companion object{
    val images = arrayListOf(
        Image(ImageList.IM1,DescipList.DESC1,Star.NOSTAR,R.raw.sound1,R.drawable.ic_empty_hearth),
        Image(ImageList.IM2,DescipList.DESC2,Star.NOSTAR,R.raw.sound2,R.drawable.ic_empty_hearth),
        Image(ImageList.IM3,DescipList.DESC3,Star.NOSTAR,R.raw.sound3,R.drawable.ic_empty_hearth),
        Image(ImageList.IM4,DescipList.DESC4,Star.NOSTAR,R.raw.sound4,R.drawable.ic_empty_hearth),
        Image(ImageList.IM5,DescipList.DESC5,Star.NOSTAR,R.raw.sound5,R.drawable.ic_empty_hearth),
        Image(ImageList.IM6,DescipList.DESC6,Star.NOSTAR,R.raw.sound6,R.drawable.ic_empty_hearth),
        Image(ImageList.IM7,DescipList.DESC7,Star.NOSTAR,R.raw.sound7,R.drawable.ic_empty_hearth),
        Image(ImageList.IM8,DescipList.DESC8,Star.NOSTAR,R.raw.sound8,R.drawable.ic_empty_hearth),
        Image(ImageList.IM9,DescipList.DESC9,Star.NOSTAR,R.raw.sound9,R.drawable.ic_empty_hearth),
        Image(ImageList.IM10,DescipList.DESC10,Star.NOSTAR,R.raw.sound10,R.drawable.ic_empty_hearth)
     )}


    }