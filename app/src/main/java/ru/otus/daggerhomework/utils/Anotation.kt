package ru.otus.daggerhomework.utils

import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Scope
import kotlin.reflect.KClass

@Scope
annotation class ActivityScope

@Scope
annotation class FragmentScope
@Scope
annotation class FragmentScope2

@Scope
annotation class ViewModelScoupe

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.PROPERTY_GETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelkey(val value: KClass<out ViewModel>)