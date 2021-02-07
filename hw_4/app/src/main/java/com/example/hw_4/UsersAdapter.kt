package com.example.hw_4

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter() :  RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    private var list = listOf<User>()

    fun submitList(newList: List<User>?) {
        list = newList ?: listOf()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val nameTv = view.findViewById<TextView>(R.id.name_tv)
        private val winsTv = view.findViewById<TextView>(R.id.wins_tv)
        private val losesTv = view.findViewById<TextView>(R.id.loses_tv)


        fun bind(item: User) {
            nameTv.text = "${item.name}"
            winsTv.text = "${item.wins}"
            losesTv.text = "${item.loses}"

        }
    }
}