package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment

class FragmentReceiver : Fragment() {
    private var _fragmentReceiverComponent: FragmentReceiverComponent? = null
    private val fragmentReceiverComponent: FragmentReceiverComponent get() = _fragmentReceiverComponent!!

    private val selfViewModel: ViewModelReceiver by viewModelWithSavedState {
        fragmentReceiverComponent.receiverViewModel().create(it)
    }

    private lateinit var frame: View

    override fun onAttach(context: Context) {
        super.onAttach(context)
        _fragmentReceiverComponent = (requireActivity() as MainActivity).mainActivityComponent.fragmentReceiverComponent()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        selfViewModel.colorRgbaLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                populateColor(it)
            }
        }
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }

    override fun onDetach() {
        super.onDetach()
        _fragmentReceiverComponent = null
    }
}