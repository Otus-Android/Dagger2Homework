package ru.otus.daggerhomework.main

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorStateColorValueImpl
import ru.otus.daggerhomework.GetColorValue
import ru.otus.daggerhomework.SetColorValue

@Module
abstract class MainModule {

    @Binds
    abstract fun providesGetColorValue(colorStateFlowImpl: ColorStateColorValueImpl): GetColorValue

    @Binds
    abstract fun providesSetColorValue(colorStateFlowImpl: ColorStateColorValueImpl): SetColorValue
}
