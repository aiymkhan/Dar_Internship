package com.example.hw_2_

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SecondActivity: AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_page_2)

        var list: MutableList<Student> = ArrayList()

        for (i in 1..3) {
            val student = Student("Name$i","Surname$i")
            list.add(student)
        }

        var bundle = intent.extras
        val student = bundle?.getParcelable<Student>("student")
        Log.d ("asd", student?.name + student?.surname)
        if (student != null) {
            list.add(student)
        }
        var recyclerView = findViewById<RecyclerView>(R.id.rv_student_list)
        var studentAdapter = StudentAdapter(list)
        studentAdapter.notifyDataSetChanged()



//        val rv = findViewById<RecyclerView>(R.id.rv_student_list)


    }


}