package ru.otus.daggerhomework.applicaion

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.Flow
import ru.otus.daggerhomework.receiver.ViewModelReceiver
import javax.inject.Inject
import javax.inject.Named

class ViewModelFactory @Inject constructor(
    @Named("ApplicationContext")
    private val context: Context,
    private val colorsFlow: Flow<Int>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ViewModelReceiver(context, colorsFlow) as T

}


