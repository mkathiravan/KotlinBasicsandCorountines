package net.kathir.kotlinbasicsandadvancedcorountines.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InfoModel(
    val name: String,
    val url: String,
    val description: String) : Parcelable