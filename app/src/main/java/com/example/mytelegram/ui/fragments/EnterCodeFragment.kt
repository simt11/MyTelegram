package com.example.mytelegram.ui.fragments

import androidx.fragment.app.Fragment
import com.example.mytelegram.utilits.AppTextWatcher
import com.example.mytelegram.utilits.showToast
import com.example.vovatelegram.R
import kotlinx.android.synthetic.main.fragment_enter_code.register_input_code

class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {
    override fun onStart() {
        super.onStart()
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string = register_input_code.text.toString()
            if (string.length == 6) {
                verifiCode()
            }
        })
    }

    private fun verifiCode() {
        showToast("Ok")
    }
}