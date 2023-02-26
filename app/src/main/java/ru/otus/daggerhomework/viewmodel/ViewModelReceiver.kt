package ru.otus.daggerhomework.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.AppContext
import ru.otus.daggerhomework.repository.ColorRepositoryImpl
import javax.inject.Inject

class ViewModelReceiver @Inject  constructor(
    @AppContext private val context: Context,
    colorRepositoryImpl: ColorRepositoryImpl
) {
    val color = colorRepositoryImpl.getColorFlow()

    fun observeColors() { if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}