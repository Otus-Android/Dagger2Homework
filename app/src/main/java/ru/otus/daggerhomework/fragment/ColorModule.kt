package ru.otus.daggerhomework.fragment

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.activity.ActivityScope
import ru.otus.daggerhomework.application.ApplicationScope

@Module
interface ColorModule {

    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator

}