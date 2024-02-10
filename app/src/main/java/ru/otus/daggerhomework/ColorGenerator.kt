package ru.otus.daggerhomework

import android.graphics.Color
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.util.*
import javax.inject.Inject

interface ColorGenerator {
    fun generateColor(): Int
    suspend fun getColor(): Flow<Int>
}

class ColorGeneratorImpl @Inject constructor() : ColorGenerator {

    companion object {
        var color: Int = -11332255
    }

    private val rnd = Random()

    override fun generateColor(): Int {
        val rnd = Random()
        color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        return color
    }

    override suspend fun getColor(): Flow<Int> {
        return flowOf(color)
    }

}