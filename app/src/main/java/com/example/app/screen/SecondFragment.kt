package com.example.app.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.app.R
import com.example.app.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second,container,false)

        val userDataArgs = SecondFragmentArgs.fromBundle(requireArguments()).userData


        binding.userData = userDataArgs  // here we set the user data to the variable of user data in xml file ..


        binding.lifecycleOwner = this



        return binding.root
    }




}