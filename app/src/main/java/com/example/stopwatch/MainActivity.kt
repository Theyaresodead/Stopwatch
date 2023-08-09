package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Chronometer
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var start=false
    private var offset: Long=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chronometer = findViewById<Chronometer>(R.id.chronometer)
        val startbutton = findViewById<Button>(R.id.startbtn)
        val resetbutton = findViewById<Button>(R.id.resetbtn)
        val stopbutton = findViewById<Button>(R.id.stopbtn)

        startbutton.setOnClickListener{
           if(start==false)
           {

               chronometer.start()
               start=true
           }
        }
        stopbutton.setOnClickListener{
            if(start==true)
            {
                chronometer.stop()
                offset=SystemClock.elapsedRealtime()-chronometer.getBase();
                start=false
            }
        }
        resetbutton.setOnClickListener{
            chronometer.setBase(SystemClock.elapsedRealtime())
            offset = 0
            start=false
        }
    }
}