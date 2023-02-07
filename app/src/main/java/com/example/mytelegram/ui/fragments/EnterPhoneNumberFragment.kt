package com.example.mytelegram.ui.fragments

import com.example.mytelegram.activities.RegisterActivity
import com.example.mytelegram.utilits.AUTH
import com.example.mytelegram.utilits.replaceActivity
import com.example.mytelegram.utilits.replaceFragment
import com.example.mytelegram.utilits.showToast
import com.example.vovatelegram.MainActivity
import com.example.vovatelegram.R
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_phone_number.register_btn_next
import kotlinx.android.synthetic.main.fragment_enter_phone_number.register_input_phone_number
import java.util.concurrent.TimeUnit

class EnterPhoneNumberFragment : BaseFragment(R.layout.fragment_enter_phone_number) {

    private lateinit var phoneNumber: String
    private lateinit var callback: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onStart() {
        super.onStart()
        AUTH = FirebaseAuth.getInstance()
        callback = object: PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                AUTH.signInWithCredential(credential).addOnCompleteListener{task ->
                    if (task.isSuccessful){
                        showToast(getString(R.string.verifi_sucess_hello))
                        (activity as RegisterActivity).replaceActivity(MainActivity())
                    } else {
                        showToast(task.exception?.message.toString())
                    }
                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                showToast(p0.message.toString())
            }

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(id, token)
                replaceFragment(EnterCodeFragment(phoneNumber, id))
            }
        }
        register_btn_next.setOnClickListener() { sendCode() }

    }

    override fun onStop() {
        super.onStop()
    }

    private fun sendCode() {
        if (register_input_phone_number.text.toString().isEmpty()) {
            showToast(getString(R.string.register_toast_enter_phone))
        } else {
            authUser()
        }
    }

    private fun authUser() {
        phoneNumber = register_input_phone_number.text.toString()
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            phoneNumber,
            60,
            TimeUnit.SECONDS,
            activity as RegisterActivity,
            callback
        )
    }
}


/*
PhoneAuthOptions
.newBuilder(FirebaseAuth.getInstance())
.setActivity(activity as RegisterActivity)
.setPhoneNumber(phoneNumber)
.setTimeout(60L, TimeUnit.SECONDS)
.setCallbacks(callback)
.build()*/
