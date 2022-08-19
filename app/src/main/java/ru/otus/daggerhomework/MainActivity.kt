package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var _mainActivityComponent: MainActivityComponent? = null
    val mainActivityComponent: MainActivityComponent
        get() = _mainActivityComponent ?: throw RuntimeException("mainActivityComponent is null")

    override fun onCreate(savedInstanceState: Bundle?) {
        injectMainActivityComponent()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragmentProducer()
    }

    private fun injectMainActivityComponent() {
        _mainActivityComponent =
            (application as App).applicationComponent
                .mainActivityComponentFactory()
                .create(this)
        mainActivityComponent.inject(this)
    }

    private fun addFragmentProducer() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, FragmentProducer.newInstance())
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _mainActivityComponent = null
    }
}