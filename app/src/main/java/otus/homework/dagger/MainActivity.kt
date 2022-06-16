package otus.homework.dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import otus.homework.dagger.di.ActivityComponent
import otus.homework.dagger.di.DaggerActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent = DaggerActivityComponent.factory().create(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}