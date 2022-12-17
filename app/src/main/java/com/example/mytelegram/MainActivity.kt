package com.example.vovatelegram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vovatelegram.databinding.ActivityMainBinding
import androidx.appcompat.widget.Toolbar
import com.example.mytelegram.ui.fragments.ChatsFragment
import com.example.mytelegram.ui.objects.AppDrawer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appDrawer: AppDrawer
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFuncMaterial()
    }

    private fun initFuncMaterial() {
        setSupportActionBar(toolbar)
        appDrawer.create()
        supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer, ChatsFragment()).commit()
    }

    private fun initFields() {
        toolbar = binding.mainToolbar
        appDrawer = AppDrawer(this, toolbar)
    }
}