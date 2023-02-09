package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Named

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val producer: MutableLiveData<Int>
): ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        producer.postValue(colorGenerator.generateColor())
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}

class ViewModelProducerFactory @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @Named("activityContext") private val context: Context,
    private val producer: MutableLiveData<Int>
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //require(modelClass == ViewModelProducer::class)
        return ViewModelProducer(colorGenerator, context, producer) as T
    }



}