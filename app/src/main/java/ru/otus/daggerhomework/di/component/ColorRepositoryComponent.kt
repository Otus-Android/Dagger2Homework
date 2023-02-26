package ru.otus.daggerhomework.di.component

import dagger.Component
import ru.otus.daggerhomework.repository.ColorRepositoryImpl

@Component
interface ColorRepositoryComponent {
    fun inject(colorRepositoryImpl: ColorRepositoryImpl)
}