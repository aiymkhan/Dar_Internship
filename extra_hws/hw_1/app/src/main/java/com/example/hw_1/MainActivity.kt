package com.example.hw_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import com.example.hw_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.navigate.setOnClickListener{
            val toPass = binding.nameField.text
            if (toPass.isNullOrEmpty()) {
                Toast.makeText(this@MainActivity, "Text fields cannot be empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val bundle = Bundle()
            bundle.putString("name", toPass.toString())
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }


    }
}