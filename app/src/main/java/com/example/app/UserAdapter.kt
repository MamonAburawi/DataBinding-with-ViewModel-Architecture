package com.example.app

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.SingleRowBinding


class UserAdapter(private val clickListener : ClickListener) : ListAdapter<UserData,UserAdapter.ViewHolder>(DiffCallback) {


   class ViewHolder(private val binding:  SingleRowBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun binding(parent: ViewGroup): ViewHolder {
                return ViewHolder(SingleRowBinding.inflate(LayoutInflater.from(parent.context)))
            }
        }

         fun onBind(data: UserData) {
             binding.userData = data
             binding.executePendingBindings()
        }

    }


    companion object DiffCallback : DiffUtil.ItemCallback<UserData>(){
        override fun areItemsTheSame(oldItem: UserData, newItem: UserData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UserData, newItem: UserData): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.binding(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userData = getItem(position)
        holder.itemView.setOnClickListener {
            clickListener.onclick(userData)
        }
        holder.onBind(userData)
    }


    class ClickListener(val clickListener : (click : UserData) -> Unit){
        fun onclick(userData: UserData) = clickListener(userData)
    }


}


