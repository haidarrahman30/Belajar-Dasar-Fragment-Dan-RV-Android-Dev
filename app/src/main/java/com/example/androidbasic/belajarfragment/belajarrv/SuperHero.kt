package com.example.androidbasic.belajarfragment.belajarrv

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SuperHero(
    val name: String,
    val desc: String
) : Parcelable