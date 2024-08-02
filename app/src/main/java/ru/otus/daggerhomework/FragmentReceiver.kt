package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.otus.daggerhomework.di.DaggerFragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    @Inject
    lateinit internal var viewModelReceiver: ViewModelReceiver

    private lateinit var frame: View

    override fun onAttach(context: Context) {
        DaggerFragmentReceiverComponent.factory().create(
            activityComponent = (requireActivity() as MainActivity).mainActivityComponent
        ).inject(this)
        super.onAttach(context)
    }

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

        viewModelReceiver.observeColors()
            .onEach { populateColor(it) }
            .launchIn(lifecycleScope)
    }

    fun populateColor(color: GeneratedColor) {
        when (color) {
            is GeneratedColor.Success -> frame.setBackgroundColor(color.colorInt)
            GeneratedColor.Default -> Unit
        }
    }
}