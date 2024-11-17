package com.mironchik.multimodule

import android.content.Context

interface CoreProvider {
    fun provideContext(): Context
}