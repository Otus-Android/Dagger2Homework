package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorRepository
import ru.otus.daggerhomework.ColorRepositoryImpl
import ru.otus.daggerhomework.ColorRepositoryReadOnly
import ru.otus.daggerhomework.ColorRepositoryWriteOnly

@Module
interface ColorRepositoryModule {

    @Binds
    fun bindColorRepository(colorRepositoryImpl: ColorRepositoryImpl): ColorRepository

    @Binds
    fun bindColorRepositoryReadOnly(colorRepository: ColorRepository): ColorRepositoryReadOnly

    @Binds
    fun bindColorRepositoryWriteOnly(colorRepository: ColorRepository): ColorRepositoryWriteOnly
}