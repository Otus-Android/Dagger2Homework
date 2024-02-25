package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var mainActivityComponent: MainActivityComponent? = null

    fun getMainActivityComponent() : MainActivityComponent? = mainActivityComponent

//    @Inject
//    lateinit var myObserver: MyObServer
//
//    @Inject
//    lateinit var myObServerMutable: MyObServerMutable

    override fun onCreate(savedInstanceState: Bundle?) {

        mainActivityComponent = DaggerMainActivityComponent.factory().create(
            (application as App).getAppComponent(), this
        )
        mainActivityComponent!!.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_producer, FragmentProducer())
            .add(R.id.fragment_reciever, FragmentReceiver())
            .commit()
    }
}