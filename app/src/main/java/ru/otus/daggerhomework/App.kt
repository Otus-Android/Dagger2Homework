package ru.otus.daggerhomework

import android.app.Application

class App: Application() {
   /* companion object {
        fun getComponent(): ApplicationComponent {
            return appComponent
        }
        lateinit  private var appComponent: ApplicationComponent
    }*/

    override fun onCreate() {
        super.onCreate()

        // Instance of the AppComponent that will be used by all the Activities in the project


    }


}


