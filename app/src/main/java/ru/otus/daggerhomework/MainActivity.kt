package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.component.DaggerMainActivityComponent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        DaggerMainActivityComponent
            .factory()
            .create((application as App).applicationComponent, this)
            .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frame1, FragmentProducer())
        fragmentTransaction.add(R.id.frame2, FragmentReceiver())
        fragmentTransaction.commit()
    }
}