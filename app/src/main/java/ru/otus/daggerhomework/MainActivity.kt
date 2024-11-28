package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.flow.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityComponent: MainActivityComponent
    private val flow: MutableStateFlow<Int> = MutableStateFlow(-1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityComponent = DaggerMainActivityComponent.factory().create(this, flow)

        supportFragmentManager.beginTransaction().add(R.id.container, FragmentReceiver()).commit()
        supportFragmentManager.beginTransaction().add(R.id.container, FragmentProducer()).commit()
    }

    fun getComponent(): MainActivityComponent = mainActivityComponent
}