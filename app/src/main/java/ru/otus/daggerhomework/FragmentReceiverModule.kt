package ru.otus.daggerhomework

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
interface FragmentReceiverModule {
    companion object{

        @Provides
        fun provideContext(@ApplicationContext context: Context): Context{
            return context
        }

    }
}