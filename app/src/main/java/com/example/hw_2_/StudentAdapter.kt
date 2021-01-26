package com.example.hw_2_

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class StudentAdapter(private val dataSet: List<Student>): RecyclerView.Adapter<StudentAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student,parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = dataSet[position]
        holder.name_tv.text = current.name
        holder.surname_tv.text = current.surname
    }


    override fun getItemCount() = dataSet.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name_tv: TextView
        val surname_tv: TextView

        init {
            name_tv = view.findViewById(R.id.name_tv)
            surname_tv = view.findViewById(R.id.surname_tv)
        }

    }


}
