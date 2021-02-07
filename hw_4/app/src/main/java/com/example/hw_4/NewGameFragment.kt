package com.example.hw_4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw_4.databinding.FragmentNewGameBinding

class NewGameFragment : Fragment(R.layout.fragment_new_game) {
    private val repository = UsersRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val binding  = FragmentNewGameBinding.bind(view)

        binding.playBtn.setOnClickListener {
            val name1: String = binding.user1Et.text.toString()
            val name2: String = binding.user2Et.text.toString()

            if (name1 == name2){
                Toast.makeText(activity, "Choose different names", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            if (name1.isNullOrEmpty() || name2.isNullOrEmpty()) {
                Toast.makeText(activity, "User names cannot be empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            repository.addUser(name1)
            repository.addUser(name2)


            findNavController().navigate(NewGameFragmentDirections.actionNewGameFragmentToActualGameFragment(
                arrayOf(name1,name2)))
        }
    }
}