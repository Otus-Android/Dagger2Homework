package ru.otus.daggerhomework

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import javax.inject.Inject


class MainActivity : AppCompatActivity() {


    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this,this.application)
    }

    @Inject
    protected lateinit var colorGenerator: ColorGenerator


    @Inject
    protected lateinit var fragmentProducer: FragmentProducer

    @Inject
    protected lateinit var fragmentReceiver: FragmentReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


         appComponent.inject(this)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.producerFragmentLayout,fragmentProducer)
                .commitAllowingStateLoss()

            supportFragmentManager.beginTransaction()
                .replace(R.id.receiverFragmentLayout, fragmentReceiver)
                .commitAllowingStateLoss()


        }
       /* val observer = Observer<ViewModelProducer.Result> { result ->
            Toast.makeText(this, "Color received at fragment", Toast.LENGTH_LONG).show()
        }

        viewModel.result.observe(appContext, observer)*/


    }
}