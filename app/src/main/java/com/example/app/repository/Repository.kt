package com.example.app.repository

import androidx.lifecycle.LiveData
import com.example.app.model.UserData
import com.example.app.database.DataBase


class Repository(){

   private val database = DataBase()

    fun setName(name : String){
        database.setName(name)
    }

    fun getName() : LiveData<String> =  database.getName()


//    fun setValue(name : String){
//        database.addValue(name)
//    }

    fun getList() :  ArrayList<UserData> = database.getList()


//    fun removeItem(x: Int){
//        database.removeItem(x)
//    }

}
