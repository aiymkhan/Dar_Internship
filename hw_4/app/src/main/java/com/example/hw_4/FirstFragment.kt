package com.example.hw_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.hw_4.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding  = FragmentFirstBinding.bind(view)

        binding.newGameBtn.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_newGameFragment)
        }
        binding.userRecordsBtn.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_userRecordsFragment2)
        }
    }
}