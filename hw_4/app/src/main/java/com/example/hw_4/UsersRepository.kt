package com.example.hw_4

import android.util.Log

object UsersRepository {

    private var IdCounter = 0
        get() {
            field++
            return field
        }


    private val users = mutableListOf<User>()

    fun getUsers() = users

    fun addUser(name: String) {
        val user = User(name)
        val contains = getUserByName(name)
        if (contains == -1) {
            users.add(user)
            Log.d("List", "Insert: ${user.name} ${users}")
        }
    }

    fun getUserByName(name: String): Int{
        return users.indexOf(
            users.find {
                user -> user.name == name
        })

    }


    fun updateUser(name: String, won: Boolean){
        val position  = getUserByName(name)
        if(won)
            users[position].wins = users[position].wins + 1
        else
            users[position].loses = users[position].loses + 1
    }


}
