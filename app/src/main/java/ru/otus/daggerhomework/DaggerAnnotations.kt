package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Qualifier
import javax.inject.Scope
import kotlin.reflect.KClass

@Qualifier
annotation class ActivityContext

@Scope
@Retention(AnnotationRetention.RUNTIME)

annotation class ActivityScope

@Qualifier
annotation class ApplicationContext

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope

@Qualifier
annotation class ColorState

@Qualifier
annotation class ProducerColorState

@MapKey
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContextQualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContextQualifier
