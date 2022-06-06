package otus.homework.dagger.di

import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import otus.homework.dagger.ColorFlow
import otus.homework.dagger.FragmentProducer
import otus.homework.dagger.FragmentReceiver
import javax.inject.Scope

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    var context: Context

    fun injectInto(producer: FragmentProducer)
    fun injectInto(receiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): ActivityComponent
    }
}

@Module
class ActivityModule {
    @get:Provides
    @ActivityScope
    var observer = ColorFlow()
}

@Scope
annotation class ActivityScope