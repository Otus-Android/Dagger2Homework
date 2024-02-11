package ru.otus.daggerhomework

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.colorexchanger.ColorExchanger
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    @ActivityContext private val context: Context,
    private val colorGenerator: ColorGenerator,
    private val colorExchanger: ColorExchanger
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_SHORT).show()
        colorExchanger.updateColor(colorGenerator.generateColor())
    }
}