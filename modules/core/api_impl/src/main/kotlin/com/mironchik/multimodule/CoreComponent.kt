package com.mironchik.multimodule

import android.content.Context
import com.mironchik.multimodule.core.api.CoreProvider
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component
interface CoreComponent : CoreProvider {
    companion object {
        fun create(context: Context): CoreComponent {
            return DaggerCoreComponent.factory().create(context)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }
}