package com.mironchik.multimodule.features.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mironchik.multimodule.base.colors.ColorsController
import com.mironchik.multimodule.base.colors.ColorsControllerProvider
import com.mironchik.multimodule.core.api.AggregatingHolder
import com.mironchik.multimodule.core.api.MediatorsProvider
import com.mironchik.multimodule.features.producer_api.ProducerMediator
import com.mironchik.multimodule.features.receiver_api.ReceiverMediator
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ColorsControllerProvider {
    @Inject lateinit var colorsController: ColorsController
    override fun provideColorsController(): ColorsController {
        return colorsController
    }
    @Inject lateinit var producerMediator: ProducerMediator
    @Inject lateinit var receiverMediator: ReceiverMediator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = DaggerMainComponent.factory().create(
            (application as AggregatingHolder).aggregatingProvider
        )
        component.inject(this)

        setContentView(R.layout.activity_main)
        producerMediator.openProducer(supportFragmentManager, R.id.fragment_producer)
        receiverMediator.openReceiver(supportFragmentManager, R.id.fragment_receiver)
    }
}