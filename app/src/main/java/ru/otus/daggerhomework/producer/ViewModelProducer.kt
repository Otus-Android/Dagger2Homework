package ru.otus.daggerhomework.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import ru.otus.daggerhomework.ColorGenerator
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelProducer @Inject constructor (
//    private val colorGenerator: ColorGenerator,
//    private val context: Context
) : ViewModel() {

//    fun generateColor() {
//        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
//        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
//    }

    fun getText() = "ViewModelProducer"
}