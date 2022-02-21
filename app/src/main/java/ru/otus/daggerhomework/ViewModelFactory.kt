package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.BindsInstance
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.di.ApplicationScope
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider



class ViewModelFactory @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val mutableStateFlow: MutableStateFlow<Int>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       if (modelClass == ViewModelProducer::class.java) {
           return ViewModelProducer(colorGenerator,context,mutableStateFlow) as T
       }
        if (modelClass == ViewModelReceiver::class.java){
            return ViewModelReceiver(context,mutableStateFlow) as T
        }
        throw RuntimeException("Unknown view model $modelClass")
    }
}