package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.FragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View
    private var component: FragmentReceiverComponent? = null
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: ViewModelReceiver by lazy {
        ViewModelProvider(this, viewModelFactory).get(ViewModelReceiver::class.java)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component = (requireActivity() as MainActivity)
            .mainActivityComponent
            .createReceiverComponent()
            .also { it.inject(this) }
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
        viewModel.observeColors(::populateColor)
    }

    fun populateColor(color: Color) {
        frame.setBackgroundColor(color.number)
    }

    override fun onDetach() {
        super.onDetach()
        component = null
    }
}