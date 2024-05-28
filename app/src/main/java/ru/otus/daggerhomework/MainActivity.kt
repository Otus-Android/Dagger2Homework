package ru.otus.daggerhomework

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    @ContextApplication
    lateinit var _applicationContext: Context

    @Inject
    @ContextActivity
    lateinit var _activityContext: Context

    private lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityComponent = DaggerMainActivityComponent
            .factory()
            .create(
                applicationComponent = (application as App)
                    .getApplicationComponent(),
                context = this,
            )
        mainActivityComponent.inject(this)
    }

    fun getMainActivityComponent(): MainActivityComponent =
        mainActivityComponent
}