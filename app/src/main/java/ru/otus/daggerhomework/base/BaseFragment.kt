package ru.otus.daggerhomework.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment<VM : ViewModel> : Fragment() {

    protected abstract val layoutId: Int

    protected abstract val viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory).get(getViewModel())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        initDagger()
    }

    protected abstract fun initDagger()

    protected abstract fun getViewModel(): Class<VM>
}