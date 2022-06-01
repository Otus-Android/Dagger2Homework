package ru.otus.daggerhomework.di.activity

import android.content.Context
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.customscopes.ActivityScope
import ru.otus.daggerhomework.di.fragment.FragmentProducerComponent
import ru.otus.daggerhomework.di.fragment.FragmentReceiverComponent
import ru.otus.daggerhomework.di.qualifiers.ActivityContext

@ActivityScope
@Subcomponent(modules = [ActivityComponentModule::class])
interface ActivityComponent {

    fun provideFragmentProducerComponentFactory(): FragmentProducerComponent.Factory

    fun provideFragmentReceiverComponentFactory(): FragmentReceiverComponent.Factory

    fun inject(activity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @ActivityContext
            @BindsInstance
            context: Context
        ): ActivityComponent
    }
}

@Module(
    subcomponents = [
        FragmentProducerComponent::class,
        FragmentProducerComponent::class
    ]
)
class ActivityComponentModule