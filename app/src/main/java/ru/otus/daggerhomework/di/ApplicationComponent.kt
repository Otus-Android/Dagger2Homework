package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.MainActivityComponent

import javax.inject.Singleton

@Singleton
@Component (modules = [AppSubcomponents::class, ColorGeneratorModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun activityComponent(): MainActivityComponent.Factory
}

@Module(subcomponents = [MainActivityComponent::class])
class AppSubcomponents{}

@Module
interface ColorGeneratorModule {
    @Binds
    fun provideColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}




