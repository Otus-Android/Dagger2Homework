package ru.otus.daggerhomework.di.modules

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.DataKeeper
import ru.otus.daggerhomework.IDataKeeper
import ru.otus.daggerhomework.di.ActivityScope

@Module
interface DataKeeperModule {
    @Binds
    @ActivityScope
    fun bindDataKeeper(dataKeeper: DataKeeper): IDataKeeper
}