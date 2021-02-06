package com.example.hw_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v: View = inflater.inflate(R.layout.fragment_first, container, false)

        val navigateBtn: Button = v.findViewById(R.id.navigate)
        val nameField: EditText = v.findViewById(R.id.name_field)


        navigateBtn.setOnClickListener{

            val toPass = nameField.text
            if (toPass.isNullOrEmpty()) {
                Toast.makeText(activity, "Text fields cannot be empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val bundle = Bundle()
            bundle.putString("name", toPass.toString())

            val fragment = SecondFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            fragment.arguments = bundle
            transaction.addToBackStack(null)
            nameField.setText("")
            transaction.replace(R.id.vg_fragment_container, fragment).commit()


        }

        return v
    }
}