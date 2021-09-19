package ru.otus.daggerhomework.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.di.module.ActivityModule

@Component(modules = [ActivityModule::class])
interface MainActivityComponent {

}