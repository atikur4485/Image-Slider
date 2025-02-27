package com.mnr.imageslider

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private var autoSlideJob: Job? = null


fun autoSlide(layout: LinearLayout, viewPager2: ViewPager2, listSize: Int) {
    autoSlideJob?.cancel() // Cancel previous job if any
    autoSlideJob = CoroutineScope(Dispatchers.Main).launch {
        while (true) {
            delay(3000) // Slide every 3 seconds
            val nextSlide = (viewPager2.currentItem + 1) % listSize
            viewPager2.setCurrentItem(nextSlide, true)
            pageIndicator(nextSlide, viewPager2.adapter?.itemCount ?: 0, layout)
        }
    }
}

fun pageIndicator(position: Int = 0, dotCount: Int = 4, layout: LinearLayout) {
    val dots = mutableListOf<ImageView>()
    layout.removeAllViews()
    val layoutParams = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.WRAP_CONTENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    ).apply { setMargins(13, 0, 13, 0) }

    for (i in 0 until dotCount) {
        val dot = ImageView(layout.context).apply {
            setImageResource(R.drawable.ob_inactive_color)
            this.layoutParams = layoutParams
        }
        dots.add(dot)
        layout.addView(dot)
    }
    if (position in 0 until dots.size) {
        dots[position].apply {
            setImageResource(R.drawable.ob_active_color)
        }
    }
}
