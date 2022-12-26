package ru.otus.daggerhomework.modules

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.scopes_and_qualifiers.ActivityScope

@Module
interface ColorGeneratorModule {

    @ActivityScope
    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

}