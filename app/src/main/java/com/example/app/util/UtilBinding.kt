package com.example.app

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.app.adapter.UserAdapter
import com.example.app.model.UserData

@BindingAdapter("userName")
    fun TextView.setTextUserName(item: UserData?){
    item?.let {
        text = item.name
    }
}

@BindingAdapter("dataList")
fun recyclerViewUser(recyclerView: RecyclerView , userData: ArrayList<UserData?>){
    val adapter = recyclerView.adapter as UserAdapter
    adapter.submitList(userData)
}


