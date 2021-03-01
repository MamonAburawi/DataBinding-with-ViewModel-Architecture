package com.example.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

@Suppress("UNUSED_CHANGED_VALUE")
class DataBase() {

    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    private var x : Int = 0



    private val _list =  MutableLiveData<List<UserData>>()
    private val list :LiveData<List<UserData>> = _list




    init {
        val newList = ArrayList<UserData>()
        newList.add(UserData(1,"mamon"))
        newList.add(UserData(1,"Ali"))
        newList.add(UserData(1,"jamal"))
        newList.add(UserData(1,"Mohamed"))
        newList.add(UserData(1,"said"))
        newList.add(UserData(1,"Osama"))
        newList.add(UserData(1,"Ali"))
        newList.add(UserData(1,"zedan"))
        _list.value = newList
    }



    fun getList() :  LiveData<List<UserData>>{
        return list
    }

    fun setName(value : String){
        _name.value = value
    }

    @JvmName("getName1")
    fun getName() :  LiveData<String>{
        return name
    }

//    fun removeItem(x : Int){
//        list.removeAt(x)
//        _list.value = list
//    }

}