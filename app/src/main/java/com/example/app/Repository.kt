package com.example.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class Repository(){

   private val database = DataBase()

    fun setName(name : String){
        database.setName(name)
    }

    fun getName() : LiveData<String> =  database.getName()


//    fun setValue(name : String){
//        database.addValue(name)
//    }

    fun getList() :  LiveData<List<UserData>> = database.getList()


//    fun removeItem(x: Int){
//        database.removeItem(x)
//    }

}
