package ru.otus.daggerhomework

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val dataKeeper: IDataKeeper
) {
    suspend fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()

        dataKeeper.saveData(colorGenerator.generateColor())
    }
}