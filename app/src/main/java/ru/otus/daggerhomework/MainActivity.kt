package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject
import javax.inject.Scope

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMainActivityComponent.factory()
            .create(
                activityContext = this,
                applicationComponent = (application as App).applicationComponent
            )
            .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

@Module(subcomponents = [FragmentReceiverComponent::class, FragmentProducerComponent::class])
object MainActivityModule {
    @Provides
    @ActivityScope
    fun observer(): Channel<Result> {
        return Channel()
    }
}

@Component(modules = [MainActivityModule::class], dependencies = [ApplicationComponent::class])
@ActivityScope
interface MainActivityComponent {
    fun activityContext(): Context

    @ApplicationContext
    fun applicationContext(): Context

    fun observer(): Channel<Result>

    fun receiverComponent(): FragmentReceiverComponent.Factory
    fun producerComponent(): FragmentProducerComponent.Factory
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activityContext: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }
}

@Scope
annotation class ActivityScope
