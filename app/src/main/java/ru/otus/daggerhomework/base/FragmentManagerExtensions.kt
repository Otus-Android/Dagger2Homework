package ru.otus.daggerhomework.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun FragmentManager.replaceFragment(
    container: Int,
    fragment: Fragment,
    needBackstack: Boolean = false
) {
    beginTransaction().apply {
        replace(container, fragment)
        if (needBackstack) {
            addToBackStack(fragment::class.java.name)
        }
    }.commit()
}

fun FragmentManager.addFragment(container: Int, fragment: Fragment) {
    this.beginTransaction()
        .add(container, fragment)
        .commit()
}