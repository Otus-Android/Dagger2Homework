package ru.otus.daggerhomework.views

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.components.ActivityComponent
import ru.otus.daggerhomework.di.components.AppComponent
import ru.otus.daggerhomework.di.components.DaggerActivityComponent
import ru.otus.daggerhomework.di.modules.viewModels.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var appComponent: AppComponent
    lateinit var activityComponent: ActivityComponent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent = (application as App).appComponent
        activityComponent = DaggerActivityComponent
            .factory()
            .create(appComponent,
                MutableStateFlow<Int>(0),
                this
            )
        setContentView(R.layout.activity_main)
        showFragment(FragmentProducer())


    }
    fun showFragment(fragment: Fragment){
        val fram = supportFragmentManager.beginTransaction()
        fram.add(R.id.fragment_main,fragment, "FirstFragment")
        fram.commit()
    }

}
