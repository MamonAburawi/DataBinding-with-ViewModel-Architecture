package com.example.app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    val id : Int,
    val name : String
):Parcelable






