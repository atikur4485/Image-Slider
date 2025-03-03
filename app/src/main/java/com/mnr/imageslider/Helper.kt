package com.mnr.imageslider

import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private var autoSlideJob: Job? = null

/**
 * Auto-slides the ViewPager2 every 3 seconds.
 * @param viewPager2 The ViewPager2 to slide.
 * @param listSize The number of items in the ViewPager2.
 */
fun autoSlide(
    imageDelayTimer: Long = 5000,
    viewPager2: ViewPager2,
    listSize: Int
) {
    autoSlideJob?.cancel() // Cancel previous job if any
    autoSlideJob = CoroutineScope(Dispatchers.Main).launch {
        while (true) {
            delay(imageDelayTimer) // Slide every -- seconds
            val nextSlide = (viewPager2.currentItem + 1) % listSize
            viewPager2.setCurrentItem(nextSlide, true)
        }
    }
}

