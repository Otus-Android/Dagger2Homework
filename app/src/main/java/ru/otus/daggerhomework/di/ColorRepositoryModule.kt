package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorRepositoryImpl
import ru.otus.daggerhomework.IColorRepository
import ru.otus.daggerhomework.IColorRepositoryReadOnly
import ru.otus.daggerhomework.IColorRepositoryWriteOnly

@Module
interface ColorRepositoryModule {

    @Binds
    fun bindColorRepository(colorRepositoryImpl: ColorRepositoryImpl): IColorRepository

    @Binds
    fun bindColorRepositoryReadOnly(colorRepository: IColorRepository): IColorRepositoryReadOnly

    @Binds
    fun bindColorRepositoryWriteOnly(colorRepository: IColorRepository): IColorRepositoryWriteOnly
}