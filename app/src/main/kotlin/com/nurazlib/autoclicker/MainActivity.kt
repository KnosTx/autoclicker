package com.nurazlib.autoclicker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nurazlib.autoclicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startFloatingButton.setOnClickListener {
            startService(Intent(this, FloatingAutoClickService::class.java))
        }

        binding.stopFloatingButton.setOnClickListener {
            stopService(Intent(this, FloatingAutoClickService::class.java))
        }
    }
}