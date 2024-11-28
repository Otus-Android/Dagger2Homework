package ru.otus.daggerhomework

import androidx.lifecycle.Observer
import android.app.Application
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ViewModelReceiver @Inject constructor (
    private val colorContainer : ColorContainer,
    private val context : Context
) : Observer<Int> {
    private lateinit var receiver : ColorReceiver

    fun init(cr : ColorReceiver, lo : LifecycleOwner) {
        receiver = cr
        colorContainer.getData().observe(lo, this)
    }

    override fun onChanged(t: Int) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст приложения")
        Toast.makeText(context,"Color received", Toast.LENGTH_LONG).show()
        receiver.populateColor(t)
    }

}