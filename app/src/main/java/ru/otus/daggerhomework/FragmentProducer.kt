package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Provider

private const val TAG = "FragmentProducerTag"

class FragmentProducer : Fragment() {
    private var _fragmentProducerComponent: FragmentProducerComponent? = null
    private val fragmentProducerComponent: FragmentProducerComponent get() = _fragmentProducerComponent!!

    private val selfViewModel: ViewModelProducer by lazyViewModel {
        fragmentProducerComponent.producerViewModel().create(it)
    }

    init {
        Log.d(TAG, "init block")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach")
        _fragmentProducerComponent = (requireActivity() as MainActivity).mainActivityComponent.fragmentProducerComponent()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")

        @Suppress("DEPRECATION")
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            //отправить результат через livedata в другой фрагмент
            selfViewModel.generateColor()
        }
        selfViewModel.colorRgbaLiveData.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            button.setTextColor(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach")
        _fragmentProducerComponent = null
    }
}