package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiver @Inject constructor(
    private val context: Context,
    val receiver: LiveData<Int>
)/*: ViewModel()*/ {

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}
/*
class ViewModelReceiverFactory @Inject constructor(
    @Named("appContext") private val context: Context,
    private val receiver: LiveData<Int>
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //require(modelClass == ViewModelProducer::class)
        return ViewModelReceiver(context, receiver) as T
    }



}*/