package com.example.hw_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hw_3.fragments.FragmentA

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentA = FragmentA()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragmentA).commit()



    }




}