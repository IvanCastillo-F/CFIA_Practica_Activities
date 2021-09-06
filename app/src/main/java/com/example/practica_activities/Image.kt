package com.example.practica_activities


class Image( var imageSrc: ImageList? = null,
             var des: DescipList? = null,
           var star:Star? = Star.NOSTAR){
companion object{
    val images = arrayListOf(
        Image(ImageList.IM1,DescipList.DESC1,Star.NOSTAR),
        Image(ImageList.IM2,DescipList.DESC2,Star.NOSTAR),
        Image(ImageList.IM3,DescipList.DESC3,Star.NOSTAR),
        Image(ImageList.IM4,DescipList.DESC4,Star.NOSTAR),
        Image(ImageList.IM5,DescipList.DESC5,Star.NOSTAR),
        Image(ImageList.IM6,DescipList.DESC6,Star.NOSTAR),
        Image(ImageList.IM7,DescipList.DESC7,Star.NOSTAR),
        Image(ImageList.IM8,DescipList.DESC8,Star.NOSTAR),
        Image(ImageList.IM9,DescipList.DESC9,Star.NOSTAR),
        Image(ImageList.IM10,DescipList.DESC10,Star.NOSTAR)
    )}

   }