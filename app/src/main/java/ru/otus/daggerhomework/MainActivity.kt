package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.FragmentProducerComponent
import ru.otus.daggerhomework.di.FragmentProducerComponentHolder
import ru.otus.daggerhomework.di.FragmentReceiverComponent
import ru.otus.daggerhomework.di.FragmentReceiverComponentHolder
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity(), FragmentProducerComponentHolder, FragmentReceiverComponentHolder {
    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityComponent = DaggerMainActivityComponent.factory().create(
            this,
            (applicationContext as App).appComponent
        )

        supportFragmentManager.beginTransaction().add(
            R.id.container1,
            FragmentProducer(),
            "a"
        ).commit()
    }

    override fun getProducerComponent(): FragmentProducerComponent {
        return mainActivityComponent.provideProducerComponent()
    }

    override fun getReceiverComponent(): FragmentReceiverComponent {
        return mainActivityComponent.provideReceiverComponent()
    }
}