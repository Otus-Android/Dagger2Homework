package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.ViewModelReceiver
import javax.inject.Inject
import javax.inject.Named

class ViewModelFactory @Inject constructor(
        private val colorGenerator: ColorGenerator,
        @ActivityContext private val contextActivity: Context,
        @ApplicationContext private val contextApplication: Context,
        private val stateChanel: MutableStateFlow<Int>
    ): ViewModelProvider.Factory{

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return when (modelClass) {
                ViewModelProducer::class.java -> ViewModelProducer(
                    colorGenerator,
                    contextActivity,
                    stateChanel
                ) as T
                ViewModelReceiver::class.java -> ViewModelReceiver(
                    contextApplication,
                    stateChanel
                ) as T
                else -> null as T
            }
        }
    }