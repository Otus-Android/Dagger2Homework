package ru.otus.daggerhomework

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import ru.otus.daggerhomework.di.activity.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var component: MainActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        component = application.applicationComponent
            .activityComponent()
            .create(this).apply {
                inject(this@MainActivity)
            }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container_view, FragmentProducer())
            }
        }
    }
}

val Context.activityComponent: MainActivityComponent
    get() = (this as MainActivity).component