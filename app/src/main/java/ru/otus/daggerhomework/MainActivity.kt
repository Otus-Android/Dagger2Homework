package ru.otus.daggerhomework


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent



class MainActivity : AppCompatActivity() {
    lateinit var activityComponent: MainActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent = DaggerMainActivityComponent.factory().create(
            this,
            (this.application as App).appComponent
        )
        activityComponent.inject(this)

        /** Повесим оба фрагмента на экран*/
        supportFragmentManager.beginTransaction()
            .add(R.id.container_fragment,FragmentProducer())
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.container_fragmentB,FragmentReceiver())
            .commit()
    }
}