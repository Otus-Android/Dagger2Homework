package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiverFactory @Inject constructor(
    @Named("appContext") private val context: Context,
    private val provideEvent: MutableLiveData<Int>
) : ViewModelProvider.Factory  {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelReceiver::class.java)) {
            return ViewModelReceiver(context, provideEvent) as T
        } else {
            throw java.lang.RuntimeException()
        }
    }

}

@Module
interface ViewModelModule {

    @Binds
    fun provideViewModel(arg: ViewModelReceiverFactory): ViewModelProvider.Factory

}