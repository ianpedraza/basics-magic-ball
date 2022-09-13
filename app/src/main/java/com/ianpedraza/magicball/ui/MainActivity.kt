package com.ianpedraza.magicball.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ianpedraza.magicball.R
import com.ianpedraza.magicball.databinding.ActivityMainBinding
import com.ianpedraza.magicball.databinding.ActivityMainBinding.inflate
import com.ianpedraza.magicball.utils.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        subscribeObservers()
        setupUI()
    }

    private fun setupUI() {
        binding.askButton.setOnClickListener { viewModel.ask() }
    }

    private fun subscribeObservers() {
        viewModel.magicBallImageResource.observe(this) { event ->
            event.getContentIfNotHandled()?.let { resource ->
                binding.magicBallImage.setImageResource(resource)
            }
        }
    }
}