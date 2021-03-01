package com.example.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.app.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    private val shareViewModel : UserViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_second,container,false)

        val userDataArgs = SecondFragmentArgs.fromBundle(requireArguments()).userData

        binding.userData = userDataArgs  // here we set the user data to the variable of user data in xml file ..


        binding.lifecycleOwner = this





//        shareViewModel.userList.observe(viewLifecycleOwner, Observer {
//            if(it == null){
//                Toast.makeText(activity,"empty", Toast.LENGTH_SHORT).show()
//            }else{
//                binding.recyclerView.adapter = UserAdapter(UserClickListener { userData ->
//                    Toast.makeText(activity,"id = ${userData.id}", Toast.LENGTH_SHORT).show()
//                })
//
//            }
//        })







        return binding.root
    }


//    private fun setValueInsideList(){
//        shareViewModel.setValue(binding.EditTextName.text.trim().toString())
//        shareViewModel.updateList()
//        Toast.makeText(activity ,"Data is Updated",Toast.LENGTH_SHORT).show()
//    }


}