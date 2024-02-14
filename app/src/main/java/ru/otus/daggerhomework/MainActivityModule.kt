package ru.otus.daggerhomework

import android.graphics.Color
import androidx.annotation.ColorInt
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

typealias IntColor = @receiver:ColorInt Int

@Module
object MainActivityModule {

    @ActivityScope
    @Provides
    fun provideColorTransactionFlow(): MutableSharedFlow<IntColor> =
        MutableStateFlow(Color.TRANSPARENT)

    @Provides
    fun provideColorProducer(colorTransactionFlow: MutableSharedFlow<IntColor>) =
        ColorProducer { colorTransactionFlow.emit(it) }

    @Provides
    fun provideColorReceiver(colorTransactionFlow: MutableSharedFlow<IntColor>) =
        ColorReceiver { colorTransactionFlow }
}