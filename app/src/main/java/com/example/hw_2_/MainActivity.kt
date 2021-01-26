package com.example.hw_2_

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        findViewById<Button>(R.id.btn_goto_Page2).setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_add_student).setOnClickListener {
            val name = findViewById<EditText>(R.id.name).text.toString()
            val surname = findViewById<EditText>(R.id.surname).text.toString()

            if(name.equals("") || surname.equals(""))
            {
                val myToast = Toast.makeText(applicationContext,"Enter both - name and surname", Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.LEFT,200,200)
                myToast.show()
            }
            else{
                val student = Student(
                        name,
                        surname
                )
                val bundle =  Bundle()
                val intent =  Intent( this, SecondActivity::class.java)
                bundle.putParcelable("student", student)
                intent.putExtras(bundle)
                startActivity(intent)
            }


        }

    }
}