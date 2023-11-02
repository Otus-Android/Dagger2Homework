package ru.otus.daggerhomework.di

import android.app.Activity
import androidx.fragment.app.Fragment

interface DaggerComponent

interface ComponentProvider<T : DaggerComponent> {
    val component: T
}

inline fun <reified T : DaggerComponent> Activity.getComponent(): T {
    val app = this.application
    if (app is ComponentProvider<*> && app.component is T) {
        return app.component as T
    }

    throw IllegalStateException("no dependencies found")
}

inline fun <reified T : DaggerComponent> Fragment.getComponent(): T {
    var currentFragment = parentFragment

    while (currentFragment != null) {
        if (currentFragment is ComponentProvider<*> && currentFragment.component is T) {
            return currentFragment.component as T
        }
        currentFragment = currentFragment.parentFragment
    }

    val activity = this.requireActivity()
    if (activity is ComponentProvider<*> && activity.component is T) {
        return activity.component as T
    }

    return requireActivity().getComponent()
}