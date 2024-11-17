package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mironchik.multimodule.CoreFactory
import ru.otus.daggerhomework.di.ActivityComponent
import ru.otus.daggerhomework.di.ActivityComponentProvider
import ru.otus.daggerhomework.di.DaggerActivityComponent

class MainActivity : AppCompatActivity(), ActivityComponentProvider {
    private lateinit var component: ActivityComponent
    override fun provideActivityComponent(): ActivityComponent = component

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component = DaggerActivityComponent.factory().create(App.component, this)

        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_producer, FragmentProducer())
            .add(R.id.fragment_receiver, FragmentReceiver())
            .commit()
        CoreFactory.create(this)
    }
}