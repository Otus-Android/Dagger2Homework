package ru.otus.daggerhomework

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Named

interface FragmentProducerDependencies {
    @Named(NAME_ACTIVITY_CONTEXT)
    fun activityContext(): Context
    fun mutableColorState(): MutableStateFlow<@JvmSuppressWildcards ColorState>
}