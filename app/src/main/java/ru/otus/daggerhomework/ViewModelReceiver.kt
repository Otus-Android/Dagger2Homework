package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelReceiver(
    private val context: Context,
    val observer: MutableLiveData<Int>
) : ViewModel() {

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_SHORT).show()
    }
}