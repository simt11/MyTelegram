package com.example.mytelegram.ui.fragments

import com.example.mytelegram.utilits.replaceFragment
import com.example.mytelegram.utilits.showToast
import com.example.vovatelegram.R
import kotlinx.android.synthetic.main.fragment_enter_phone_number.register_btn_next
import kotlinx.android.synthetic.main.fragment_enter_phone_number.register_input_phone_number

class EnterPhoneNumberFragment : BaseFragment(R.layout.fragment_enter_phone_number) {

    override fun onStart() {
        super.onStart()
        register_btn_next.setOnClickListener() { sendCode() }
    }

    private fun sendCode() {
        if (register_input_phone_number.text.toString().isEmpty()) {
            showToast(getString(R.string.register_toast_enter_phone))
        } else {
            replaceFragment(EnterCodeFragment())
        }
    }
}