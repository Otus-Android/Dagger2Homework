package otus.homework.dagger

import android.graphics.Color
import androidx.annotation.ColorInt
import java.util.*

interface ColorGenerator {

    @ColorInt
    fun generateColor(): Int
}

class ColorGeneratorImpl : ColorGenerator {

    override fun generateColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}