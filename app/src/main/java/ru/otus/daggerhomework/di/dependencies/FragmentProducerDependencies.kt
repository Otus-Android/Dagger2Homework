package ru.otus.daggerhomework.di.dependencies

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow

interface FragmentProducerDependencies {

    fun activityContext(): Context

    fun mutableColorState(): MutableStateFlow<Int>
}