package com.mironchik.multimodule

import android.app.Application
import com.mironchik.multimodule.core.api.AggregatingHolder
import com.mironchik.multimodule.core.api.AggregatingProvider
import com.mironchik.multimodule.core.api_factory.CoreFactory

class App : Application(), AggregatingHolder {
    override val aggregatingProvider: AggregatingProvider by lazy {
        DaggerAggregatingComponent.factory().create(CoreFactory.create(this))
    }
}