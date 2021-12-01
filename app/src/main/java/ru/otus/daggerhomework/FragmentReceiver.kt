package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import ru.otus.daggerhomework.di.DaggerFragmentComponentReceiver
import ru.otus.daggerhomework.di.FragmentComponentProduser
import ru.otus.daggerhomework.di.FragmentComponentReceiver
import javax.inject.Inject

class FragmentReceiver : Fragment() {
    lateinit var componentReceiver: FragmentComponentReceiver

    @Inject
    lateinit var factoryReceiver: ViewModelReceiver.FactoryReceiver
    private val viewModelReceiver by viewModels<ViewModelReceiver> { factoryReceiver }
    private lateinit var frame: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        componentReceiver = DaggerFragmentComponentReceiver.factory()
            .create((requireActivity() as MainActivity).appComponent)
        componentReceiver.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
        lifecycleScope.launchWhenResumed {
            viewModelReceiver.observeColors()
            viewModelReceiver.receiverStateFlow.collect {
                populateColor(it)
            }
        }
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}