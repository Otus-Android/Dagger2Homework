package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import ru.otus.daggerhomework.di.ActivityComponent
import ru.otus.daggerhomework.di.DaggerActivityComponent

@ExperimentalCoroutinesApi
@FlowPreview
class MainActivity : AppCompatActivity() {
    companion object{
        lateinit var component: ActivityComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component = DaggerActivityComponent.factory().create(this, App.component)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.fragment_producer, FragmentProducer())
            .add(R.id.fragment_receiver, FragmentReceiver()).commit()
    }
}