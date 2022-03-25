package ru.otus.daggerhomework.viewModels

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.components.ApplicationContext
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext
    private val context: Context
) : ViewModel() {

    @Inject
    lateinit var stateFlow: StateFlow<Int>

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}