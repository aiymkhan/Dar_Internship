package com.example.hw_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayOfComputed = arrayOfNulls<Int>(21)

        findViewById<Button>(R.id.random).setOnClickListener{
            val randomNumber: Int = getRandomInt()

            var computedNumber: Int
//            Log.d("asd: ", randomNumber.toString())

            if (arrayOfComputed[randomNumber] == null) {
                computedNumber = someHeavyComputation(randomNumber)
                arrayOfComputed[randomNumber] = computedNumber
//                Log.d("asd: ","Not Skipped")
            }
            computedNumber = arrayOfComputed[randomNumber]!!
            findViewById<TextView>(R.id.tvResult).text = "Result for ${randomNumber} is ${computedNumber}"

        }
    }


    fun getRandomInt() = (0..20).random()

    /* This function just simulates some heavy computation */
    fun someHeavyComputation(num: Int): Int {
        try {
            Thread.sleep(2000)
        } catch(e: Exception) {}
        return num*num;
    }


}