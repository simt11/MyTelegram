package com.example.mytelegram.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vovatelegram.R
import com.example.vovatelegram.databinding.FragmentChatsBinding

class ChatsFragment : Fragment() {
    private lateinit var binding: FragmentChatsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
    }

}