package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), DependenciesProvider<MainActivityComponent> {
    
    lateinit var activityComponent: MainActivityComponent
    
    override fun onCreate(savedInstanceState: Bundle?) {
        val dependenciesProvider = application as? DependenciesProvider<MainActivityDependencies>
            ?: throw ClassCastException(
                "App must implement `DependenciesProvider` of `MainActivityDependencies`"
            )
        activityComponent = DaggerMainActivityComponent.factory()
            .create(dependenciesProvider.getDependencies(), this)
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fReceiver, FragmentReceiver())
                .replace(R.id.fProducer, FragmentProducer())
                .commit()
        }
    }
    
    override fun getDependencies(): MainActivityComponent = activityComponent
    
}