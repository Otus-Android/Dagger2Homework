package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {
    fun provideColorGenerator(): ColorGenerator
    @ActivityQualifier
    fun activityContext(): Context

//    @AppQualifier
//    fun provideAppContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityQualifier context: Context, applicationComponent: ApplicationComponent
        ): ActivityComponent
    }


    val observerFlow: MutableStateFlow<Int>
}

@Module
interface ActivityModule {
    companion object {
        @Provides
        @ActivityScope
        fun provideColorEvent(): MutableStateFlow<Int> {
            return MutableStateFlow(0)
        }
    }

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}