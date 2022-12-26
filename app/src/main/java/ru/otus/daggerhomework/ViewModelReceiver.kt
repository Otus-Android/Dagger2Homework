package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.flow.*
import ru.otus.daggerhomework.scopes_and_qualifiers.ActivityContext
import ru.otus.daggerhomework.scopes_and_qualifiers.ActivityScope
import ru.otus.daggerhomework.scopes_and_qualifiers.AppContext
import ru.otus.daggerhomework.scopes_and_qualifiers.FragmentScope
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext val context: Context,
    val stateFlow: StateFlow<Int>
) {

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}