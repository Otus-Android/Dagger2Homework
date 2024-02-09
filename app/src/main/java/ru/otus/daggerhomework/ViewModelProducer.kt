package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject


class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,

    @ActivityContext
    private val context: Context,

    private val myObserver: MyObserver
) {
    suspend fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        myObserver.send(colorGenerator.generateColor())
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}