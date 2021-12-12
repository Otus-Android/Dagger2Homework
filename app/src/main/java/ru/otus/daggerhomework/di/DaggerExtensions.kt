package ru.otus.daggerhomework.di

import android.content.Context
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.ui.MainActivity

val Context.applicationComponent: ApplicationComponent
    get() = when (this) {
        is App -> this.component
        else -> this.applicationContext.applicationComponent
    }

val Fragment.activityComponent: MainActivityComponent
    get() = (this.requireActivity() as MainActivity).component