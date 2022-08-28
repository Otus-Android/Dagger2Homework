package ru.otus.daggerhomework

import android.graphics.Color
import androidx.annotation.ColorInt
import java.util.Random
import javax.inject.Inject

interface ColorGenerator {
  @ColorInt
  fun generateColor(): Int
}

class ColorGeneratorImpl @Inject constructor() : ColorGenerator {

  override fun generateColor(): Int {
    val rnd = Random()
    val res = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    return res
  }
}