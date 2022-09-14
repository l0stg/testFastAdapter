package com.example.somefood.ui.helloScreen

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.somefood.R
import com.example.somefood.databinding.FragmentHelloScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HelloScreenFragment : Fragment(R.layout.fragment_hello_screen) {

    private val binding: FragmentHelloScreenBinding by viewBinding()
    private val viewModel: HelloScreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = getString(R.string.app_name)
        
        binding.buttonSignIn.setOnClickListener {
            viewModel.openSigIn()
        }

        binding.buttonRegistration.setOnClickListener {
            viewModel.openRegistration()
        }
    }
}