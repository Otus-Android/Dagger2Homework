package com.mironchik.multimodule.core.api_factory

import android.content.Context
import com.mironchik.multimodule.CoreComponent
import com.mironchik.multimodule.core.api.CoreProvider

object CoreFactory {
    fun create(context: Context): CoreProvider {
        return CoreComponent.create(context)
    }
}