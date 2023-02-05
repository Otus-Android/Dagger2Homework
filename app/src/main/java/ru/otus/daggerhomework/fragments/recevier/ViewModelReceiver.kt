package ru.otus.daggerhomework.fragments.recevier

import android.app.Application
import android.content.Context
import android.widget.Toast
import ru.otus.daggerhomework.di.AppContext
import ru.otus.daggerhomework.fragments.BaseViewModel
import ru.otus.daggerhomework.utils.ColorConsumer
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context,
    private val colorConsumer: ColorConsumer
) : BaseViewModel {

    fun getColorConsumer(): ColorConsumer {
        observeColors()

        return colorConsumer
    }

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}
