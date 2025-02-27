package com.mnr.imageslider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
        binding.viewPagerId.adapter = viewPagerAdapter(images)
        autoSlide(binding.indicatorLayoutId, binding.viewPagerId, images.size)
        pageIndicator(layout = binding.indicatorLayoutId)
    }
//
//    private fun autoSlide() {
//        autoSlideJob?.cancel() // Cancel previous job if any
//        autoSlideJob = CoroutineScope(Dispatchers.Main).launch {
//            while (true) {
//                delay(3000) // Slide every 3 seconds
//                val nextSlide = (binding.viewPagerId.currentItem + 1) % images.size
//                binding.viewPagerId.setCurrentItem(nextSlide, true)
//                pageIndicator(nextSlide)
//            }
//        }
//    }

//    private fun pageIndicator(position: Int) {
//        Log.e("Atikru", "Current Position: $position")
//
//        val dotCount = binding.viewPagerId.adapter?.itemCount?:0
//        val dots = mutableListOf<ImageView>()
//        binding.indicatorLayoutId.removeAllViews()
//        val layoutParams = LinearLayout.LayoutParams(
//            ViewGroup.LayoutParams.WRAP_CONTENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT
//        ).apply { setMargins(13, 0, 13, 0) }
//
//        for (i in 0 until dotCount) {
//            val dot = ImageView(this).apply {
//                setImageResource(R.drawable.ob_inactive_color)
//                this.layoutParams = layoutParams
//            }
//            dots.add(dot)
//            binding.indicatorLayoutId.addView(dot)
//        }
//        if (position in 0 until dots.size) {
//            dots[position].setImageResource(R.drawable.ob_active_color)
//        }
//    }


}