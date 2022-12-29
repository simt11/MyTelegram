package com.example.mytelegram.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import com.example.vovatelegram.R

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    // Методы необходимые для данного обьекта
    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu,menu)
    }


}