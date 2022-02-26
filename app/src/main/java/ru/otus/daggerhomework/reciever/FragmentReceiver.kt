package ru.otus.daggerhomework.reciever

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.base.BaseFragment
import ru.otus.daggerhomework.base.callView
import ru.otus.daggerhomework.base.launchWhenStarted
import ru.otus.daggerhomework.di.receiver.DaggerFragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : BaseFragment<ViewModelReceiver>() {

    companion object {
        fun newInstance() = FragmentReceiver()
    }

    override val layoutId: Int = R.layout.fragment_b

    @Inject
    override lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeData()
    }

    override fun initDagger() {
        DaggerFragmentReceiverComponent
            .factory()
            .create((activity as MainActivity).activityComponent)
            .inject(this)
    }

    override fun getViewModel(): Class<ViewModelReceiver> {
        return ViewModelReceiver::class.java
    }

    private fun populateColor(@ColorInt color: Int) {
        callView<View>(R.id.frame) {
            setBackgroundColor(color)
        }
    }

    private fun observeData() {
        with(viewModel) {
            receiver.launchWhenStarted(lifecycleScope) { color ->
                populateColor(color)
            }
        }
    }
}