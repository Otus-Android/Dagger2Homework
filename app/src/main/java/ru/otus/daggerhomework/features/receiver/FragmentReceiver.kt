package ru.otus.daggerhomework.features.receiver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.DaggerFragmentReceiverComponent
import ru.otus.daggerhomework.di.getComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    @Inject
    lateinit var viewModel: ViewModelReceiver

    private var frame: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        DaggerFragmentReceiverComponent.factory().create(
            mainActivityComponent = getComponent()
        ).inject(this)

        viewModel.observeColors()
            .onEach(::populateColor)
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        frame = null
    }

    private fun populateColor(@ColorInt color: Int) {
        frame?.setBackgroundColor(color)
    }

    companion object {
        fun newInstance(): FragmentReceiver =
            FragmentReceiver()
    }
}