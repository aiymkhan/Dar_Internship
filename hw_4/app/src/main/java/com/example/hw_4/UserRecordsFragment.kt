package com.example.hw_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw_4.databinding.FragmentUserRecordsBinding


class UserRecordsFragment : Fragment(R.layout.fragment_user_records)
{
    private val repository = UsersRepository
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentUserRecordsBinding.bind(view)

        binding.run {
            val adapter = UsersAdapter()
            usersRv.adapter = adapter
            adapter.submitList(repository.getUsers())

            mainPageBtn.setOnClickListener{

                findNavController().navigate(UserRecordsFragmentDirections.actionUserRecordsFragment2ToFirstFragment())
            }
        }
    }
}