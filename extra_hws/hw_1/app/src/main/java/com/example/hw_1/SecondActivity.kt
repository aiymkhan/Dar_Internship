package com.example.hw_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.hw_1.databinding.ActivityMainBinding

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



        val showBtn: Button = findViewById(R.id.show_message)

        lateinit var profileName: String

        intent.extras?.let {
           profileName = it.getString("name") ?: ""
        }


        showBtn.setOnClickListener{
            Toast.makeText(this@SecondActivity,profileName, Toast.LENGTH_SHORT).show()
        }

    }

}