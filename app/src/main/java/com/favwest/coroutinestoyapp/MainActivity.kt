package com.favwest.coroutinestoyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.text_view)
        val vm = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        textView.text = vm.currentNumber.value.toString()

        val numberObserver = Observer<Int> {
            textView.text = it.toString()
        }

        vm.currentNumber.observe(this, numberObserver)

        val countButton = findViewById<Button>(R.id.count_button)
        countButton.setOnClickListener {
            runBlocking { vm.countUpSlowly() }
        }
    }
}