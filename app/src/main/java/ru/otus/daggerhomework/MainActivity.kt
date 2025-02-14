package ru.otus.daggerhomework

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : FragmentActivity() {

    lateinit var component: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        application
        component = DaggerMainActivityComponent.factory().build(this)
        setContentView(R.layout.activity_main)
    }
}

val FragmentActivity.component: MainActivityComponent get() = (this as MainActivity).component