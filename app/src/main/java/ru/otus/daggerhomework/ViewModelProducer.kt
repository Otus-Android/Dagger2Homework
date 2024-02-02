package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val myViewModel: MyViewModel
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        myViewModel.sendEvent(colorGenerator.generateColor())
    }
}