package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Binds
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.AppContext
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @AppContext private val context: Context,
    private val event : MutableLiveData<Int>
) {

    fun generateColor() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        event.value = colorGenerator.generateColor()
    }
}