package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.subjects.PublishSubject

class MainActivity : AppCompatActivity() {

    val mainActivityComponent: MainActivityComponent by lazy {
        DaggerMainActivityComponent.factory().create(
            applicationComponent = (application as App).appComponent,
            context = this,
            observer = PublishSubject.create()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

