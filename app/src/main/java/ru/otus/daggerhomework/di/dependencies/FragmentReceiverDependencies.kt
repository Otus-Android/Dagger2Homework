package ru.otus.daggerhomework.di.dependencies

import android.content.Context
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.utils.ApplicationContext

interface FragmentReceiverDependencies {

    @ApplicationContext
    fun appContext(): Context

    fun colorState(): StateFlow<Int>
}