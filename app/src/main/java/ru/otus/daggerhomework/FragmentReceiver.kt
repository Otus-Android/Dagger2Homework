package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Subcomponent
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var receiverComponent: FragmentReceiverComponent
    lateinit var viewModel: ViewModelReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity).activityComponent.receiverComponent().create().inject(this)
        viewModel = ViewModelProvider(
            this, receiverComponent.viewModelFactory()
        )[ViewModelReceiver::class.java]
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

        viewModel.color.observe(viewLifecycleOwner) {
            populateColor(it)
        }
        viewModel.observeColors()
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}

@Subcomponent
interface FragmentReceiverComponent {
    @ApplicationContext
    fun applicationContext(): Context

    fun observer(): Channel<Result>
    fun inject(fragmentReceiver: FragmentReceiver)
    fun viewModelFactory(): ViewModelReceiver.Factory

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentReceiverComponent
    }
}
