package com.example.demo1

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.demo1.databinding.ActivityMainBinding
import com.example.di_app_mad.domain.ApiResponse
import com.example.di_app_mad.domain.PostModel
import com.example.di_app_mad.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel: PostViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel.list.observe(this) {
            Log.e("TAG", "onCreate: ====>>> ${it}")

            when (it) {
                is ApiResponse.Loading -> {
                    binding.textView.setVisibility(View.GONE)
                    binding.progressBar.setVisibility(View.VISIBLE)
                }

                is ApiResponse.Error -> {
                    binding.textView.setText(it.exception.message)
                    binding.progressBar.setVisibility(View.GONE)
                }
                is ApiResponse.Success -> {
                    binding.textView.setVisibility(View.VISIBLE)
                    binding.textView.setText(it.data[0].title)
                    binding.progressBar.setVisibility(View.GONE)
                }

                else -> {
                }
            }
        }

    }
}