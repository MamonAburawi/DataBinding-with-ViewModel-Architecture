package com.example.app

import android.content.Context
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

@BindingAdapter("userName")
    fun TextView.setTextUserName(item:UserData?){
    item?.let {
        text = item.name
    }
}

@BindingAdapter("dataList")
fun recyclerViewUser(recyclerView: RecyclerView , userData: ArrayList<UserData?>){
    val adapter = recyclerView.adapter as UserAdapter
    adapter.submitList(userData)
}


