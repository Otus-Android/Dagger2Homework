package ru.otus.daggerhomework.di.components

import android.content.Context
import dagger.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.dependencies.FragmentProducerDependencies
import ru.otus.daggerhomework.di.dependencies.FragmentReceiverDependencies
import ru.otus.daggerhomework.di.dependencies.MainActivityDependencies
import ru.otus.daggerhomework.utils.ActivityScope

@ActivityScope
@Component(
    dependencies = [MainActivityDependencies::class],
    modules = [MainMutableStateModule::class, MainStateModule::class]
)
interface MainActivityComponent : FragmentProducerDependencies, FragmentReceiverDependencies {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context,
            mainActivityDependencies: MainActivityDependencies
        ): MainActivityComponent
    }
}

@Module
class MainMutableStateModule {

    @ActivityScope
    @Provides
    fun provideMutableStateFlow(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }
}

@Module
interface MainStateModule {

    @ActivityScope
    @Binds
    fun bindsStateFlow(
        mutableStateFlow: MutableStateFlow<Int>
    ): StateFlow<Int>
}
