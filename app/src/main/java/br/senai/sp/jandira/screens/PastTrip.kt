package br.senai.sp.jandira.model

import android.media.Image

data class PastTrip(
    val image: Int,
    val location: String,
    val date: String,
    val description: String
)

