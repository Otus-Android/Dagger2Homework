package ru.otus.daggerhomework

import android.content.Context
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Named

interface FragmentReceiverDependencies {
    
    @Named(NAME_APP_CONTEXT)
    fun appContext(): Context
    
    fun colorState(): StateFlow<@JvmSuppressWildcards ColorState>
    
}