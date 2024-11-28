package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import dagger.Binds
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var appContext : Context

    @Inject
    lateinit var viewModel : ViewModelProducer

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ((context as Activity).application as App).appComponent.createFragmentProducerComponent().inject(this)
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
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
    }
}