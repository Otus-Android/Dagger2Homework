package ru.otus.daggerhomework

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    protected lateinit var colorGenerator: ColorGenerator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          DaggerMainActivityComponent.builder()
            .build()
            Toast.makeText(this, colorGenerator.generateColor().toString(),1).show()
       // val producerViewModel = ViewModelProducerFactory(colorGenerator,this)
       // val receiverViewModel = ViewModelReceiverFactory(this)



        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.producerFragmentLayout, FragmentProducer(colorGenerator,this))
                .commitAllowingStateLoss()

            supportFragmentManager.beginTransaction()
                .replace(R.id.receiverFragmentLayout, FragmentReceiver())
                .commitAllowingStateLoss()


        }
       /* val observer = Observer<ViewModelProducer.Result> { result ->
            Toast.makeText(this, "Color received at fragment", Toast.LENGTH_LONG).show()
        }

        viewModel.result.observe(appContext, observer)*/


    }
}