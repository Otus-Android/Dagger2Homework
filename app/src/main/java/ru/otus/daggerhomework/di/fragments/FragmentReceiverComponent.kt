package ru.otus.daggerhomework.di.fragments

import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.di.AppContext
import ru.otus.daggerhomework.di.DaggerFragmentReceiverComponent
import ru.otus.daggerhomework.di.FragmentReceiverScope
import ru.otus.daggerhomework.di.activity.ActivityComponent
import ru.otus.daggerhomework.presentation.FragmentReceiver
import ru.otus.daggerhomework.presentation.viewmodels.ReceiverViewModel

/**
 * TODO: добавить описание класса
 *
 * @author Евтушенко Максим 11.11.2023
 */
@FragmentReceiverScope
@Component(
    modules = [FragmentReceiverViewModel::class],
    dependencies = [ActivityComponent::class]
)
interface FragmentReceiverComponent {
    companion object {
        fun getFragmentReceiverComponent(activityComponent: ActivityComponent): FragmentReceiverComponent =
            DaggerFragmentReceiverComponent.builder()
                .activityComponent(activityComponent)
                .build()
    }

    fun inject(fragment: FragmentReceiver)
}

@Module
object FragmentReceiverViewModel {

    @Provides
    fun provideViewModelReceiver(
        @AppContext context: Context
    ) = ReceiverViewModel(context)
}