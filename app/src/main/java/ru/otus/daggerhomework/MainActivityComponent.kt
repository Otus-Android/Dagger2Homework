package ru.otus.daggerhomework

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ActivityScope
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Singleton


@Component(
    modules = [ActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
@ActivityScope
interface MainActivityComponent {
         @Component.Factory
        interface Factory{
        fun create(
            @BindsInstance @ActivityContext context: Context,
            component: ApplicationComponent,
            @BindsInstance stateFlow: MutableStateFlow<Int>
        ):MainActivityComponent
    }
    @ActivityContext
    fun provideActivityContext(): Context

    @ApplicationContext
    fun provideApplicationContext(): Context

    fun provideColorGenerate(): ColorGenerator

    fun provideObserver(): MutableStateFlow<Int>
}

@Module
interface ActivityModule{
    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl):ColorGenerator
}