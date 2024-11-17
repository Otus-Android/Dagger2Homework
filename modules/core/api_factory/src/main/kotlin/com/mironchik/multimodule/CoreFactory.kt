package com.mironchik.multimodule

import android.content.Context

object CoreFactory {
    fun create(context: Context): CoreProvider {
        return CoreComponent.create(context)
    }
}