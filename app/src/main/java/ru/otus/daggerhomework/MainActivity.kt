package ru.otus.daggerhomework

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Qualifier
import javax.inject.Scope

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityComponent = DaggerMainActivityComponent.factory().create(this, applicationComponent)
        setContentView(R.layout.activity_main)
    }
}

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
)
interface MainActivityComponent {

    @AppContext
    fun providesAppContext(): Context
    @ActivityContext
    fun provideActivityContext(): Context
    fun providesStateFlow(): MutableStateFlow<Int>

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ActivityContext context: Context,
                   applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }
}

@Scope
annotation class ActivityScope

@Qualifier
annotation class ActivityContext

