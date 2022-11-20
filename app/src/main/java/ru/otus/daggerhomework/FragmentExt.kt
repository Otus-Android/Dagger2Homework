package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

inline val Fragment.manager: FragmentManager
    get() = requireActivity().supportFragmentManager

fun Fragment.setFragment(fragment: Fragment) =
    manager
        .beginTransaction()
        .addToBackStack(fragment.javaClass.name)
        .replace(R.id.container, fragment, fragment.javaClass.name)
        .commit()

fun AppCompatActivity.setFragment(fragment: Fragment) =
    supportFragmentManager.beginTransaction()
        .replace(R.id.container, fragment, fragment::class.java.name)
        .commitAllowingStateLoss()
