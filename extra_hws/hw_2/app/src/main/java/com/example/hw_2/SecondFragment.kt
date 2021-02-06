package com.example.hw_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class SecondFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_second, container, false)

        val message = arguments?.getString("name")
        val showBtn = v.findViewById<Button>(R.id.show_message)


        showBtn.setOnClickListener{

            Toast.makeText(activity,message, Toast.LENGTH_SHORT).show()

        }
        return v
    }
}