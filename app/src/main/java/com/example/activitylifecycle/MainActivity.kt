package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.activitylifecycle.mymodels.MyData

class MainActivity : AppCompatActivity() {
    private lateinit var myValue : MyData
    //var myValue :String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MainActivity", "onCreate")

        myValue = ViewModelProvider(this).get(com.example.activitylifecycle.mymodels.MyData::class.java)
        val btn : Button = findViewById(R.id.btnOK)
        val tvName : TextView = findViewById(R.id.tvName)
        val tvAge : TextView = findViewById(R.id.tvAge)

//        if (savedInstanceState != null){
//            myValue = savedInstanceState.getString("value").toString()
//            tv.text = myValue
//        }

        myValue.name.observe(this, Observer{
                newName -> tvName.text = newName
        })

        myValue.age.observe(this, Observer{
                newAge -> tvAge.text = newAge.toString()
        })

        if(myValue.name.value != ""){

            //display()
            //.....add code here
        }

        btn.setOnClickListener(){
            myValue.name.value = "John"
            myValue.age.value = 21
            //display()
        }
    }


//    fun display(){
//        val tv : TextView = findViewById(R.id.tvName)
//        tv.text = myValue.name
//    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString("value", myValue)
//    }
//
//    override fun onStart(){
//        super.onStart()
//        Log.i("MainActivity", "onStart")
//    }
//
//    override fun onResume(){  //UI is ready to interact and show on screen
//        super.onResume()
//        Log.i("MainActivity", "onResume")
//    }
//
//    override fun onPause(){
//        super.onPause()
//        Log.i("MainActivity", "onPause")
//    }
//
//    override fun onStop(){
//        super.onStop()
//        Log.i("MainActivity", "onStop")
//    }
//
//    override fun onDestroy(){
//        super.onDestroy()
//        Log.i("MainActivity", "onDestroy")
//    }

}