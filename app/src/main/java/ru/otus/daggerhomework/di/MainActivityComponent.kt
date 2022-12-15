package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.MainActivity
import javax.inject.Named

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class, ApplicationSubcomponents::class]
)
interface MainActivityComponent {

    @Named("appContext")
    fun getApplicationContext(): Context

    @Named("activityContext")
    fun getActivityContext(): Context

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance @Named("activityContext") context: Context
        ): MainActivityComponent
    }

    fun inject(activity: MainActivity)

    fun producerComponent(): FragmentProducerComponent.Factory

    fun receiverComponent(): FragmentReceiverComponent.Factory
}

@Module
class MainActivityModule {

    @Provides
    fun provideColorGenerator(): ColorGenerator = ColorGeneratorImpl()

    @Provides
    fun provideColorMutableStateFlow(): MutableStateFlow<Int> = MutableStateFlow(0)
}
