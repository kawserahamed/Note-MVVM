package org.primeit.googlenotes.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.primeit.googlenotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}