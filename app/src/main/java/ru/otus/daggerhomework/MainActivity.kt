package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.app.ApplicationComponent
import ru.otus.daggerhomework.di.qualifiers.AppContext
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @AppContext
    @Inject
    lateinit var appContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        provideDependencies().inject(this@MainActivity)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("myDebug", "onCreate: appContext -> $appContext")
    }
}

fun Context.provideDependencies(): ApplicationComponent =
    (this as? App)?.componentInstance
        ?: this.applicationContext?.provideDependencies()
        ?: throw Throwable()