package com.example.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.*

@Suppress("CAST_NEVER_SUCCEEDS")
class UserViewModel() : ViewModel() {

    private val repository = Repository()

    val name: LiveData<String> = repository.getName()

//    private val pictureListLive: MutableLiveData<ArrayList<String>> = MutableLiveData()
//    val list : LiveData<ArrayList<String>> = pictureListLive



    private val _userList = MutableLiveData<List<UserData>>()
    val userList : LiveData<List<UserData>>
        get() = _userList


    private val _navigateToSelectedProperty = MutableLiveData<UserData>()
    val navigateToSelectedProperty:LiveData<UserData> = _navigateToSelectedProperty


    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)




//    private val _userList: MutableLiveData<ArrayList<UserData>> = MutableLiveData()
//    val userList : LiveData<ArrayList<UserData>>
//    get() = _userList
//


    init {
        val newList = ArrayList<UserData>()
        newList.add(UserData(1,"mamon"))
        newList.add(UserData(2,"Ali"))
        newList.add(UserData(3,"jamal"))
        newList.add(UserData(4,"Mohamed"))
        newList.add(UserData(5,"said"))
        newList.add(UserData(6,"Osama"))
        newList.add(UserData(7,"Ali"))
        newList.add(UserData(8,"zedan"))
        _userList.value = newList
//        updateList()
    }



    fun navigateToSelectedProperty(userData: UserData){
        _navigateToSelectedProperty.value = userData
    }

    fun navigateToSelectedPropertyCompleted(){
        _navigateToSelectedProperty.value = null
    }

//    private val list : ArrayList<String> = repository.getList()

//    val list : LiveData<ArrayList<String>> = repository.getList() as LiveData<ArrayList<String>>

//    @JvmName("getList1")
//    fun getList() :  ArrayList<String>{
//        return list
//    }

//    fun setName(value: String){
//        viewModelScope.launch {
//            repository.setName(value)
//        }
//
//    }

//    fun setValue(name: String){
//        viewModelScope.launch {
//            repository.setValue(name)
//            updateList()
//        }
//    }

    fun updateList(){
        viewModelScope.launch {
            _userList.value = repository.getList().value
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}