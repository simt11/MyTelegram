package com.example.mytelegram.ui.fragments

import androidx.fragment.app.Fragment

open class BaseFragment(val layout: Int) : Fragment(layout) {
    // Инициализация методов необходимых для всех фрагментов
    override fun onStart() {
        super.onStart()
    }
}