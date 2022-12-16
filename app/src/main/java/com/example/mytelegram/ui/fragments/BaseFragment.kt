package com.example.mytelegram.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


open class BaseFragment(val layout: Int) : Fragment() {
    private lateinit var rootView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(layout, container, false)
        return rootView
    }

    // Инициализация методов необходимых для всех фрагментов
    override fun onStart() {
        super.onStart()
    }
}