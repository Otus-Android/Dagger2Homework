package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.AppContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext
    private val context: Context,
    private val myObServer: MyObServer
) {

    private val scope = CoroutineScope(Dispatchers.Main + Job())

    private val _colorData = MutableStateFlow(0)
    val colorData = _colorData
    fun observeColors() {

        scope.launch {
            if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")

            myObServer.observe().collect {
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                _colorData.value = it
            }
        }

    }

    fun onClear() {
        scope.cancel()
    }
}