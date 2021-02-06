package com.example.hw_2b

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.hw_2b.databinding.FragmentFirstBinding
import com.example.hw_2b.databinding.FragmentSecondBinding


class SecondFragment : Fragment(R.layout.fragment_second) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding  = FragmentSecondBinding.bind(view)



        binding.showMessage.setOnClickListener{

                Toast.makeText(activity, arguments?.getString("name"), Toast.LENGTH_SHORT).show()

        }

    }
}