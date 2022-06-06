package otus.homework.dagger

import android.app.Application
import otus.homework.dagger.di.*
import otus.homework.dagger.di.AppModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        activityComponent = DaggerActivityComponent.factory().create(appComponent)
        fragmentReceverComponent = DaggerFragmentReceiverComponent.factory().create(activityComponent)
        fragmentProducerComponent = DaggerFragmentProducerComponent.factory().create(activityComponent)
    }

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var activityComponent: ActivityComponent
        lateinit var fragmentReceverComponent: FragmentReceiverComponent
        lateinit var fragmentProducerComponent: FragmentProducerComponent
    }
}