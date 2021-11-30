package ru.otus.daggerhomework.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.components.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.components.MainActivityComponent
import ru.otus.daggerhomework.di.dependencies.DependenciesProvider
import ru.otus.daggerhomework.di.dependencies.MainActivityDependencies
import ru.otus.daggerhomework.presentation.producer.FragmentProducer

class MainActivity : AppCompatActivity(), DependenciesProvider<MainActivityComponent> {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dependenciesProvider = application as? DependenciesProvider<MainActivityDependencies>
            ?: throw ClassCastException(
                "App must implement `DependenciesProvider` of `MainActivityDependencies`"
            )


        mainActivityComponent = DaggerMainActivityComponent
            .factory()
            .create(this, dependenciesProvider.getDependencies())


        supportFragmentManager
            .beginTransaction()
            .add(R.id.container_layout, FragmentProducer(), FragmentProducer.TAG)
            .addToBackStack(null)
            .commit()
    }

    override fun getDependencies(): MainActivityComponent = mainActivityComponent
}