package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenCreated
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class FragmentProducer : Fragment(), LifecycleObserver {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners(view)
    }

    private fun setListeners(view: View) {
        lifecycleScope.launch {
            viewModel.stateFlow.collect {
                when (it) {
                    is ProducerEvents.Empty -> {
                    }
                    is ProducerEvents.OpenReceiver -> {
                        findNavController().navigate(R.id.action_fragmentProducer_to_fragmentReceiver)
                        viewModel.onFragmentReceiverOpened()
                    }
                }
            }
        }
        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через livedata в другой фрагмент
            viewModel.generateColor()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity?.lifecycle?.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        (activity as MainActivity).mainActivityComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModelProducer::class.java)
        activity?.lifecycle?.removeObserver(this)
    }
}