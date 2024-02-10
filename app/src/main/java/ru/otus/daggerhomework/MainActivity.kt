package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var colorGenerator: ColorGenerator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        colorGenerator = ColorGeneratorImpl()
        DaggerMainActivityComponent.factory()
            .create((this.application as App).getAppComponent(), this)
            .inject(this)
        setContentView(R.layout.activity_main)
    }
}

@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ColorGeneratorModule::class]
)
interface MainActivityComponent {
    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent, @BindsInstance context: Context
        ): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)
}

@Module
interface ColorGeneratorModule {
    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}