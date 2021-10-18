package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named

class ViewModelProducer @Inject constructor(
    private val provideEvent: MutableLiveData<Int>,
    private val colorGenerator: ColorGenerator,
    @Named("activityContext") private val context: Context
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        provideEvent.value = colorGenerator.generateColor()
    }
}