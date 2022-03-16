package ru.otus.daggerhomework

import android.app.Application
import android.app.Fragment
import android.content.Context

import dagger.*
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton


@Component()
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(
            @BindsInstance application: Application): ApplicationComponent
    }
    fun inject(application: App)
    fun provideApplication(): Application

}


@Singleton
@Component(modules = [ FragmentsModule::class,ColorGeneratorModule::class, SubscribeModule::class],
        dependencies = [ApplicationComponent::class])
interface MainActivityComponent  {

    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance context: Context): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)

    fun provideContext(): Context
}

@Module
interface ColorGeneratorModule {

    @Singleton
    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}


@Module
class SubscribeModule {

    @Singleton
    @Provides
    fun providePublishSubject():PublishSubject<Int> {
       return PublishSubject.create<Int>()
    }
}

@Module
class FragmentsModule {

    @Singleton
    @Provides
    fun provideFragmentReceiver(appContext: Application,publishSubject: PublishSubject<Int>): FragmentReceiver {
        return FragmentReceiver(application = appContext,publishSubject = publishSubject
        )
    }


    @Singleton
    @Provides
    fun provideFragmentProducer(context: Context,colorGenerator: ColorGenerator,publishSubject: PublishSubject<Int>): FragmentProducer {
        return FragmentProducer(context,colorGenerator,publishSubject)
    }
}







