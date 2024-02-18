package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.colorexchanger.ColorExchanger
import ru.otus.daggerhomework.colorexchanger.ColorExchangerImpl

@ActivityScope
@Component(
    modules = [ActivityModule::class],
    dependencies = [AppComponent::class]
)
interface ActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            @BindsInstance
            @ActivityContext
            context: Context
        ): ActivityComponent
    }

    @ApplicationContext
    fun provideApplicationContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context

    fun provideColorExchanger(): ColorExchanger

    fun inject(activity: MainActivity)
}

@Module
interface ActivityModule {
    @ActivityScope
    @Binds
    fun provideColorExchanger(colorExchanger: ColorExchangerImpl): ColorExchanger
}