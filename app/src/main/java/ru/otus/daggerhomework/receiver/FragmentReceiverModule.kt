package ru.otus.daggerhomework.receiver

import android.content.Context
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.activity.Event
import ru.otus.daggerhomework.qualifier.AppContext

@Module
object FragmentReceiverModule {

    @Provides
    fun createReceiverViewModel(
        @AppContext context: Context,
        stateEvent: StateFlow<Event>
    ) = ViewModelReceiver(context, stateEvent)
}