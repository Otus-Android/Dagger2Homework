package ru.otus.daggerhomework.di.fragments

import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.FragmentProducerScope
import ru.otus.daggerhomework.di.activity.ActivityComponent
import ru.otus.daggerhomework.domain.ColorGenerator
import ru.otus.daggerhomework.domain.ColorGeneratorImpl
import ru.otus.daggerhomework.presentation.FragmentProducer
import ru.otus.daggerhomework.presentation.viewmodels.ProducerViewModel

/**
 * TODO: добавить описание класса
 *
 * @author Евтушенко Максим 11.11.2023
 */
@FragmentProducerScope
@Component(
    modules = [ColorModule::class, FragmentProducerViewModel::class],
    dependencies = [ActivityComponent::class]
)
interface FragmentProducerComponent {

    companion object {
        fun getFragmentProducerComponent(activityComponent: ActivityComponent): FragmentProducerComponent =
            DaggerFragmentProducerComponent.builder()
                .activityComponent(activityComponent)
                .build()
    }

    fun inject(fragment: FragmentProducer)
}

@Module
object ColorModule {
    @Provides
    fun provideColorGenerator(): ColorGenerator = ColorGeneratorImpl()
}

@Module
object FragmentProducerViewModel {

    @Provides
    fun provideViewModelProducer(
        colorGenerator: ColorGenerator,
        @ActivityContext context: Context
    ) = ProducerViewModel(colorGenerator, context)
}