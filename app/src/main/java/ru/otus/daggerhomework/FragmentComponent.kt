package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FragmentModule {

    @Provides
    @Singleton
    fun provideFragmentProducer(context: Context,colorGenerator: ColorGenerator):Fragment {
        return FragmentProducer(context,colorGenerator)
    }

    @Provides
    @Singleton
    fun provideFragmentReceiver(application: Application):Fragment {
        return FragmentReceiver(application)
    }
}
