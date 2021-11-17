package ru.otus.daggerhomework.di.components

import dagger.Component
import dagger.Provides
import ru.otus.daggerhomework.di.module.ColorModule
import ru.otus.daggerhomework.producer.FragmentProducer
import ru.otus.daggerhomework.scope.FragmentScope

@FragmentScope
@Component(modules = [ColorModule::class], dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    // нужны для того, чтобы можно было туда передать эксземпляр (инстанс) фрагмента
    // потому что во фрагменте мы инжектим в поля
    // поле в кт инжектим обязательно должно быть не приватным
    fun injectFragmentProducer(fragment: FragmentProducer)

}