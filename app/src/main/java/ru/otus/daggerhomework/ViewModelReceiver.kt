package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val context: Context,
    private val observer: ColorObserver
) : ViewModel() {

    fun observeColors(): ColorObserver {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        return observer
    }
}