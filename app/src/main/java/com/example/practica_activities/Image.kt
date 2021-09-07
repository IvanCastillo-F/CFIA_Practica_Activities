package com.example.practica_activities

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class Image( var imageSrc: ImageList? = null,
             var des: DescipList? = null,
           var star:Star? = Star.NOSTAR,/*var id:Int = 0*/):Parcelable{
companion object{
    val images = arrayListOf(
        Image(ImageList.IM1,DescipList.DESC1,Star.NOSTAR,/*0*/),
        Image(ImageList.IM2,DescipList.DESC2,Star.NOSTAR,/*1*/),
        Image(ImageList.IM3,DescipList.DESC3,Star.NOSTAR,/*2*/),
        Image(ImageList.IM4,DescipList.DESC4,Star.NOSTAR,/*3*/),
        Image(ImageList.IM5,DescipList.DESC5,Star.NOSTAR,/*4*/),
        Image(ImageList.IM6,DescipList.DESC6,Star.NOSTAR,/*5*/),
        Image(ImageList.IM7,DescipList.DESC7,Star.NOSTAR,/*6*/),
        Image(ImageList.IM8,DescipList.DESC8,Star.NOSTAR,/*7*/),
        Image(ImageList.IM9,DescipList.DESC9,Star.NOSTAR,/*8*/),
        Image(ImageList.IM10,DescipList.DESC10,Star.NOSTAR,/*9*/)
        /* Image(ImageList.IM10,DescipList.DESC10,Star.NOSTAR,10)*/
     )}


    }