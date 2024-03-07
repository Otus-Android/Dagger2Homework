package ru.otus.daggerhomework


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.rxjava3.subjects.PublishSubject

class MainActivity :
    MainActivityComponentInterface,
    AppCompatActivity() {

    private lateinit var mainActivityComponent: MainActivityComponent

    private var subject = PublishSubject.create<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityComponent = DaggerMainActivityComponent.factory().create(
            this, subject,
            (this.application as ApplicationComponentInterface).getComponent()
        )
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.colored_container_fragment, FragmentReceiver())
            .add(R.id.button_fragment, FragmentProducer())
            .commit()
    }

    override fun getComponent() =  mainActivityComponent
}