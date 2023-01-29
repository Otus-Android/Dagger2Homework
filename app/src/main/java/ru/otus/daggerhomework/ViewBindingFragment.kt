package ru.otus.daggerhomework

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class ViewBindingFragment<V : ViewBinding>
    (@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    protected var binding: V? = null

}