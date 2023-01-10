package com.example.mytelegram.ui.fragments

import androidx.fragment.app.Fragment
import com.example.mytelegram.activities.RegisterActivity
import com.example.mytelegram.utilits.AUTH
import com.example.mytelegram.utilits.AppTextWatcher
import com.example.mytelegram.utilits.replaceActivity
import com.example.mytelegram.utilits.showToast
import com.example.vovatelegram.MainActivity
import com.example.vovatelegram.R
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_code.register_input_code

class EnterCodeFragment(val phoneNumber: String, val id: String) :
    Fragment(R.layout.fragment_enter_code) {

    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity).title = phoneNumber
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string = register_input_code.text.toString()
            if (string.length == 6) {
                enterCode()
            }
        })
    }

    private fun enterCode() {
        val code = register_input_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)
        AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                showToast(getString(R.string.verifi_sucess_hello))
                (activity as RegisterActivity).replaceActivity(MainActivity())
            } else {
                showToast(task.exception?.message.toString())
            }
        }
    }
}