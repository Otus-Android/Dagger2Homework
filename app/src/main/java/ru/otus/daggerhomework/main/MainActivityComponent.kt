package ru.otus.daggerhomework.main

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.colorproducer.ColorProducer
import ru.otus.daggerhomework.colorproducer.IColorHandler
import ru.otus.daggerhomework.fragments.FragmentComponentsModule
import ru.otus.daggerhomework.fragments.FragmentProducerComponent
import ru.otus.daggerhomework.fragments.FragmentReceiveComponent
import javax.inject.Scope

@MainActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class, FragmentComponentsModule::class]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext context: Context,
            appComponent: ApplicationComponent,
        ): MainActivityComponent
    }

    fun getFragmentProducerComponent(): FragmentProducerComponent.Factory

    fun getFragmentReceiveComponent(): FragmentReceiveComponent.Factory

    fun inject(activity: MainActivity)
}

@Module
interface MainActivityModule {

    @Binds
    fun bindColorHandler(colorProducer: ColorProducer): IColorHandler

    companion object {

        @Provides
        @MainActivityScope
        fun provideColorProducer(): ColorProducer = ColorProducer()
    }
}

@Scope
annotation class MainActivityScope


