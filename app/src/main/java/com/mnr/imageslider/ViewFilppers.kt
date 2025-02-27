package com.mnr.imageslider

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily
import com.mnr.imageslider.databinding.ActivityViewFilppersBinding


class ViewFilppers : AppCompatActivity() {
    private lateinit var binding: ActivityViewFilppersBinding
    private val images: List<String> = listOf(
        "https://cdn.pixabay.com/photo/2025/02/03/22/59/mountain-9380557_960_720.jpg",
        "https://cdn.pixabay.com/photo/2024/07/01/07/11/cats-8864617_1280.jpg",
        "https://cdn.pixabay.com/photo/2023/12/25/10/27/dog-8468288_960_720.jpg",
        "https://cdn.pixabay.com/photo/2024/01/08/21/31/frozen-8496388_960_720.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewFilppersBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        images.forEach {
            val imageView = ShapeableImageView(this)
            imageView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP


            // Apply rounded corners
            imageView.shapeAppearanceModel = imageView.shapeAppearanceModel
                .toBuilder()
                .setAllCorners(CornerFamily.ROUNDED, 30f) // 50dp rounded
                .build()
            Glide.with(this).load(it).into(imageView)
            binding.viewFlipperId.addView(imageView)
        }
        binding.viewFlipperId.apply {
            flipInterval = 3000
            startFlipping()
        }
//        pageIndicator(
//            position = binding.viewFlipperId.displayedChild,
//            dotCount = images.size,
//            layout = binding.indicatorLayoutId
//        )

    }
}