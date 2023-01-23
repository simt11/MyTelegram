package com.example.mytelegram.ui.fragments

import androidx.fragment.app.Fragment
import com.example.vovatelegram.MainActivity

open class BaseFragment(layout: Int) : Fragment(layout) {
    // Инициализация методов необходимых для всех фрагментов
    override fun onStart() {
        super.onStart()
        (activity as MainActivity).appDrawer.disableDrawer()
    }

    override fun onStop() {
        super.onStop()
        (activity as MainActivity).appDrawer.enableDrawer()
    }
}