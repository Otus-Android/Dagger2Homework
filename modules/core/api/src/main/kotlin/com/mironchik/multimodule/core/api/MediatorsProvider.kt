package com.mironchik.multimodule.core.api

import javax.inject.Provider

interface MediatorsProvider {
    fun provideMediatorsMap(): Map<Class<*>, @JvmSuppressWildcards Provider<Any>>
}