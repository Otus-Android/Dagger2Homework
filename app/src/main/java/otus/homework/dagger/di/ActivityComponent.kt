package otus.homework.dagger.di

import android.content.Context
import androidx.lifecycle.MutableLiveData
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@ActivityScope
@Component(modules = [MainActivityModule::class])
interface ActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ActivityComponent
    }

    fun activityContext(): Context

    val observer: MutableLiveData<Int>
}

@Module
class MainActivityModule {

    @Provides
    @ActivityScope
    fun provideColorEvent(): MutableLiveData<Int> {
        return MutableLiveData<Int>()
    }
}

@Module
class ActivityModule {
    @get:Provides
    @ActivityScope
    var observer = MutableLiveData<Int>()
}

@Scope
annotation class ActivityScope