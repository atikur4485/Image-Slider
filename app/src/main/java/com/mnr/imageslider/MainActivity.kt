package com.mnr.imageslider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.mnr.imageslider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val images: List<String> = listOf(
        "https://cdn.pixabay.com/photo/2025/02/03/22/59/mountain-9380557_960_720.jpg",
        "https://cdn.pixabay.com/photo/2024/07/01/07/11/cats-8864617_1280.jpg",
        "https://cdn.pixabay.com/photo/2023/12/25/10/27/dog-8468288_960_720.jpg",
        "https://cdn.pixabay.com/photo/2024/01/08/21/31/frozen-8496388_960_720.jpg"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.viewPagerId.adapter = ViewPagerAdapter(images)
        TabLayoutMediator(binding.tabDots, binding.viewPagerId) { _, _ -> }.attach()
        autoSlide(binding.viewPagerId, images.size)
    }

}