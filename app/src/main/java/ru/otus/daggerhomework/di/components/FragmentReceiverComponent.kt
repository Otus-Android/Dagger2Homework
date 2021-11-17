package ru.otus.daggerhomework.di.components

import dagger.Component
import dagger.Provides
import ru.otus.daggerhomework.receiver.FragmentReceiver
import ru.otus.daggerhomework.scope.FragmentScope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    // нужны для того, чтобы можно было туда передать эксземпляр (инстанс) фрагмента
    // потому что во фрагменте мы инжектим в поля
    // поле в кт инжектим обязательно должно быть не приватным
    fun injectFragmentReceiver(fragment: FragmentReceiver)

}