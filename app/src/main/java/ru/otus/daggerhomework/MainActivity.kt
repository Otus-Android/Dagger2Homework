package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.security.auth.Subject

class MainActivity : AppCompatActivity() {

    private var subject = Subject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMainActivityComponent.factory().create(this, subject)
        setContentView(R.layout.activity_main)
    }
}