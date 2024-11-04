package ru.otus.daggerhomework.fragments

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.main.AppContext
import ru.otus.daggerhomework.colorproducer.IColorHandler
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context,
    private val colorHandler: IColorHandler,
) {

    fun observeColors(): Flow<Int> {
        if (context !is Application) throw RuntimeException(context.getString(R.string.chaeck_application_context))
        return colorHandler.tickFlow.onEach {
            Toast.makeText(context, context.getString(R.string.color_received), Toast.LENGTH_LONG).show()
        }
    }
}