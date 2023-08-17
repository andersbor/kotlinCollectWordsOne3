package com.example.collectwordsone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.collectwordsone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val words = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.buttonSave.setOnClickListener {
            val word = binding.editTextWord.text.trim().toString()
            words.add(word)
        }

        binding.buttonClear.setOnClickListener {
            words.clear()
            binding.textViewMessage.text = ""
        }

        binding.buttonShow.setOnClickListener {
            binding.textViewMessage.text = words.toString()
        }
    }
}