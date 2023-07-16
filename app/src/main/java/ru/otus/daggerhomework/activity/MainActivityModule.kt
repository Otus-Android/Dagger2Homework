package ru.otus.daggerhomework.activity

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.di.ActivityScope
import ru.otus.daggerhomework.utils.Notification
import ru.otus.daggerhomework.utils.NotificationImpl

@Module
interface MainActivityModule {

    @Binds
    @ActivityScope
    fun bindNotification(notification: NotificationImpl): Notification
}