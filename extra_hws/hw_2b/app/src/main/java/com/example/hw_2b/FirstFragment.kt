package com.example.hw_2b

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw_2b.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding  = FragmentFirstBinding.bind(view)



        binding.navigate.setOnClickListener{

            val toPass = binding.nameField.text.toString()

            if (toPass.isNullOrEmpty()) {
                Toast.makeText(activity, "Text fields cannot be empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val bundle = bundleOf("name" to toPass)
            binding.nameField.setText("")
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)

        }

    }
}