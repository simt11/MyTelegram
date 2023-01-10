package com.example.mytelegram.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.mytelegram.activities.RegisterActivity
import com.example.mytelegram.utilits.AUTH
import com.example.mytelegram.utilits.replaceActivity
import com.example.vovatelegram.MainActivity
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings_menu_logout -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
        }
        return true
    }
}