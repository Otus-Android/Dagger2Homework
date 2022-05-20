package ru.otus.daggerhomework

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.Component
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModelReceiverFactory: ViewModelReceiverFactory
    private val viewModelReceiver by viewModels<ViewModelReceiver> { viewModelReceiverFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DaggerFragmentReceiverComponent
            .factory()
            .create((requireActivity() as MainActivity).mainActivityComponent)
            .inject(this)
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
        lifecycleScope.launch {
            viewModelReceiver.color.collectLatest { populateColor(it) }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        Log.d("COLOR_VALUE", color.toString())
        frame.setBackgroundColor(color)
    }
}

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: MainActivityComponent
        ): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}