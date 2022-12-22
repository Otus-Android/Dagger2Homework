package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.IDataKeeper
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ActivityScope
import ru.otus.daggerhomework.di.ApplicationContext
import ru.otus.daggerhomework.di.modules.ColorGeneratorModule
import ru.otus.daggerhomework.di.modules.DataKeeperModule

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [DataKeeperModule::class, ColorGeneratorModule::class]
)
interface ActivityComponent {

    @ActivityContext
    fun provideActivityContext(): Context

    @ApplicationContext
    fun provideApplicationContext(): Context

    fun provideDataKeeper(): IDataKeeper

    fun provideColorGenerator(): ColorGenerator

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance @ActivityContext context: Context
        ): ActivityComponent
    }
}
