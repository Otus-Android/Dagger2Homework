package ru.otus.daggerhomework.di.fragments

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.BINARY)
annotation class ViewModelKey(
    val key: KClass<out ViewModel>
)