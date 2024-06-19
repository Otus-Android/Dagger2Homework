package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val colorObservable: IColorObservable,
): ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")

        val newColor = colorGenerator.generateColor()
        colorObservable.notify(newColor)

        Toast.makeText(context, "Color sent $newColor", Toast.LENGTH_LONG).show()
    }
}

class ViewModelProducerFactory @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ContextActivity private val context: Context,
    private val colorObservable: IColorObservable,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelProducer::class.java))
            return ViewModelProducer(
                colorGenerator,
                context,
                colorObservable,
            ) as T
        else throw IllegalArgumentException()
    }

}