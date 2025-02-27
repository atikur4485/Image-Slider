import androidx.viewpager2.widget.ViewPager2
import android.view.View
import kotlin.math.abs

class DepthPageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(view: View, position: Float) {
        view.apply {
            pivotX = if (position < 0) width.toFloat() else 0f // Set pivot to left/right for rotation
            pivotY = height / 2f
            rotationY = position * -30f // Rotate Y-axis for page flip effect
            alpha = if (abs(position) > 1) 0f else 1f // Hide completely when out of view
        }
    }
}