package com.mironchik.multimodule.core.api

import android.content.Context
import javax.inject.Provider

interface CoreProvider {
    fun provideContext(): Context
}