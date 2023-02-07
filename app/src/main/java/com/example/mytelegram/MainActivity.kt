package com.example.vovatelegram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mytelegram.activities.RegisterActivity
import com.example.mytelegram.ui.fragments.ChatsFragment
import com.example.mytelegram.ui.objects.AppDrawer
import com.example.mytelegram.utilits.AUTH
import com.example.mytelegram.utilits.replaceActivity
import com.example.mytelegram.utilits.replaceFragment
import com.example.vovatelegram.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

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
        if (AUTH.currentUser!=null) {
            setSupportActionBar(toolbar)
            appDrawer.create()
            replaceFragment(ChatsFragment(), false)
        } else {
            replaceActivity(RegisterActivity())
        }
    }

    private fun initFields() {
        toolbar = binding.mainToolbar
        appDrawer = AppDrawer(this, toolbar)
        AUTH = FirebaseAuth.getInstance()

    }
}