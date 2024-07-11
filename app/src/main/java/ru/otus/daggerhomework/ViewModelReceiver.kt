package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ApplicationContext
import ru.otus.daggerhomework.di.FragmentScope
import javax.inject.Inject

@FragmentScope
class ViewModelReceiver @Inject constructor(
    private val colorObserver: ColorObserver,
    @ApplicationContext private val context: Context
) {
    fun observeColors(): LiveData<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()

        return colorObserver.color
    }
}