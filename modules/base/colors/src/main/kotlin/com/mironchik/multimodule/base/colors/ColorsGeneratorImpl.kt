package com.mironchik.multimodule.base.colors

import android.graphics.Color
import java.util.Random

class ColorsGeneratorImpl : ColorsGenerator {
    override fun generateColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}