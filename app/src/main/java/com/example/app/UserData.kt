package com.example.app

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserData(
    val id : Int,
    val name : String
):Parcelable
