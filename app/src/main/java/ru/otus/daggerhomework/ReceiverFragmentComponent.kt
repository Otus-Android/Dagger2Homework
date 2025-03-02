package ru.otus.daggerhomework

import dagger.Subcomponent

@Subcomponent
interface ReceiverFragmentComponent {
    fun inject(receiverFragment: ReceiverFragment)
}