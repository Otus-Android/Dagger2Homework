package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ViewModelModule {


    @AppScope
    @Binds
    fun bindMyViewModel(impl: MyViewModel): ViewModel


    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator

}