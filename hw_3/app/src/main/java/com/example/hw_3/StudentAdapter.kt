package com.example.hw_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class StudentAdapter: RecyclerView.Adapter<StudentAdapter.ViewHolder>(){

        private var list = listOf<Student>()

        fun submitList(newList: List<Student>?) {

            list = newList ?: listOf()
            notifyItemInserted(list.size-1)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false))
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount() = list.size

        class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

            private val tvName = view.findViewById<TextView>(R.id.tv_name)

            fun bind(item: Student) {

                tvName.text = "${item.name}"
            }
        }


}