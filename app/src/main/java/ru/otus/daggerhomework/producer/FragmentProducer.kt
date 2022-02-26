package ru.otus.daggerhomework.producer

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.base.BaseFragment
import ru.otus.daggerhomework.base.callView
import ru.otus.daggerhomework.base.replaceFragment
import ru.otus.daggerhomework.di.producer.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.reciever.FragmentReceiver
import javax.inject.Inject

class FragmentProducer : BaseFragment<ViewModelProducer>() {

    companion object {
        fun newInstance() = FragmentProducer()
    }

    override val layoutId: Int = R.layout.fragment_a

    @Inject
    override lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    override fun initDagger() {
        DaggerFragmentProducerComponent
            .factory()
            .create((activity as MainActivity).activityComponent)
            .inject(this)
    }

    override fun getViewModel(): Class<ViewModelProducer> {
        return ViewModelProducer::class.java
    }

    private fun initListeners() {
        callView<Button>(R.id.button) {
            setOnClickListener {
                viewModel.generateColor()
                replaceFragment()
            }
        }
    }

    private fun replaceFragment() {
        parentFragmentManager
            .replaceFragment(
                container = R.id.main_container,
                fragment = FragmentReceiver.newInstance(),
                needBackstack = true
            )
    }
}