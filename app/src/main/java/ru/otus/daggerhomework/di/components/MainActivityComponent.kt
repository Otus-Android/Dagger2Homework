package ru.otus.daggerhomework.di.components

import android.content.Context
import androidx.lifecycle.MutableLiveData
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.module.ActivityModule
import ru.otus.daggerhomework.scope.ActivityScope
import javax.inject.Named

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {

    // компонент уровня ниже после ApplicationComponent
    // "dependencies = " - указываем от кого будет зависеть текущий компонент

    // provision метод, чтобы прокинуть контекст ниже
    @Named("appContext")
    fun getApplicationContext(): Context

    @Named("activityContext")
    fun getActivityContext(): Context

    fun getProvideEvent(): MutableLiveData<Int>

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun activityContext(@Named("activityContext")context: Context): Builder

        fun applicationComponent(applicationComponent: ApplicationComponent): Builder

        fun build(): MainActivityComponent
    }

}