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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.app.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding : FragmentFirstBinding
    private  val shareViewModel : UserViewModel by activityViewModels() // use activityViewModels to you can user the view Model in many fragments ..


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {



        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_first,container,false)




        binding.userViewModel = shareViewModel
        binding.lifecycleOwner = this


        binding.recyclerView.adapter = UserAdapter(UserAdapter.ClickListener{
            shareViewModel.navigateToSelectedProperty(it)
            Toast.makeText(activity,"click",Toast.LENGTH_SHORT).show()
        })


        shareViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if(it != null){ // here we check if the navigateToSelectedProperty is not == null will navigate to next fragment.
                this.findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(it))
                shareViewModel.navigateToSelectedPropertyCompleted()
            }
        })



        return binding.root
    }


//     private fun setName(){
//        shareViewModel.setName(binding.EditTextName.text.trim().toString())
//    }
//
//    private fun setValueInsideList(){
//        shareViewModel.setValue(binding.EditTextName.text.trim().toString())
//    }


    private fun goTo2ndFragment(){
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
    }

}