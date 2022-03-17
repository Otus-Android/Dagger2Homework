package ru.otus.daggerhomework.di

import android.app.Application
import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.subjects.PublishSubject
import ru.otus.daggerhomework.*
import javax.inject.Scope
import javax.inject.Singleton


@FragmentScope
@Component(modules = [FragmentsModule::class],
    dependencies = [MainActivityComponent::class])
interface FragmentComponent {
    fun inject(mainActivity: MainActivity)
}


@Module
class FragmentsModule {


    @Provides
    fun provideFragmentReceiver(appContext: Application, publishSubject: PublishSubject<Int>): FragmentReceiver {
        return FragmentReceiver(application = appContext,publishSubject = publishSubject
        )
    }


    @Provides
    fun provideFragmentProducer(context: Context, colorGenerator: ColorGenerator, publishSubject: PublishSubject<Int>): FragmentProducer {
        return FragmentProducer(context,colorGenerator,publishSubject)
    }
}

@Scope
annotation class FragmentScope