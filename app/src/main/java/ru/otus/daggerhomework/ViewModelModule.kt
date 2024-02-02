package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {

    @Binds
    fun bindMyViewModel(impl: MyViewModel): ViewModel

    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator

}