package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent
import ru.otus.daggerhomework.di.appComponent

//import ru.otus.daggerhomework.di.appComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityComponent = DaggerMainActivityComponent.factory().create(this, appComponent)

        val navController = Navigation.findNavController(this, R.id.navigation)
        val navbar = findViewById<BottomNavigationView>(R.id.navbar)

        navController.setGraph(R.navigation.main_navigation)

        navbar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.toProducer -> {navController.navigate(R.id.showProducer)}
                R.id.toReceiver -> {navController.navigate(R.id.showReceiver)}
            }
            return@setOnItemSelectedListener true
        }

    }

}