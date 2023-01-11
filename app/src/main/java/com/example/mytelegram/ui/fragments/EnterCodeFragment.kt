package com.example.mytelegram.ui.fragments

import androidx.fragment.app.Fragment
import com.example.mytelegram.activities.RegisterActivity
import com.example.mytelegram.utilits.AUTH
import com.example.mytelegram.utilits.AppTextWatcher
import com.example.mytelegram.utilits.CHILD_ID
import com.example.mytelegram.utilits.CHILD_PHONE
import com.example.mytelegram.utilits.CHILD_USERNAME
import com.example.mytelegram.utilits.NODE_USERS
import com.example.mytelegram.utilits.REF_DATABASE_ROOT
import com.example.mytelegram.utilits.initFirebase
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
        initFirebase()
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
                val uid = AUTH.currentUser?.uid.toString()
                var dateMap = mutableMapOf<String, Any>()
/*                (
                    CHILD_ID to uid,
                    CHILD_PHONE to phoneNumber,
                    CHILD_USERNAME to uid
                )*/
                dateMap[CHILD_ID] = uid
                dateMap[CHILD_PHONE] = phoneNumber
                dateMap[CHILD_USERNAME] = uid
                REF_DATABASE_ROOT.child(NODE_USERS)
                    .child(uid)
                    .updateChildren(dateMap)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            showToast(getString(R.string.verifi_sucess_hello))
                            (activity as RegisterActivity).replaceActivity(MainActivity())
                        } else showToast(it.exception?.message.toString())
                    }
            } else {
                showToast(task.exception?.message.toString())
            }
        }
    }
}