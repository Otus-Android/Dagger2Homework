package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var mainActivityComponent: MainActivityComponent? = null

    @Inject
    lateinit var myObserver: MyObserver

    fun getMainActivityComponent(): MainActivityComponent?  = mainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent = DaggerMainActivityComponent.factory().create(
            (application as App).appComponent,
            this
        )
        mainActivityComponent!!.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}