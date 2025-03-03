package com.mnr.imageslider

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.mnr.imageslider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val images: List<String> = listOf(
        "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.dhiwise.com%2Fpost%2Fstreamlining-image-selection-with-flutter-image-picker-plugin&psig=AOvVaw1hR-J0j2iO78qPDc4IVoRJ&ust=1741061924874000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCJDCosmH7YsDFQAAAAAdAAAAABAE",
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
        binding.layoutImageSlider.viewPagerId.adapter = ViewPagerAdapter(images){
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        }
        TabLayoutMediator(binding.layoutImageSlider.tabDots, binding.layoutImageSlider.viewPagerId) { _, _ -> }.attach()
        autoSlide(viewPager2 = binding.layoutImageSlider.viewPagerId, listSize = images.size)
    }

}