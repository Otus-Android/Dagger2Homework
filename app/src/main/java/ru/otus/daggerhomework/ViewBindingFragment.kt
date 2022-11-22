package ru.otus.daggerhomework

import android.util.Log
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class ViewBindingFragment<V : ViewBinding>
    (@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    protected var binding: V? = null

    override fun onDestroyView() {
        super.onDestroyView()
        view?.post {
            Log.d(this.javaClass.name, "binding release ${binding?.let { it::class.simpleName }}");
            binding = null
        }
    }
}