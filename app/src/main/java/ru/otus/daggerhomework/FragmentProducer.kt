package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModelProducer: ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectFragmentProducerComponent()
    }

    private fun injectFragmentProducerComponent() {
        (requireActivity() as MainActivity).mainActivityComponent
            .fragmentProducerComponentFactory()
            .create()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            startFragmentReceiver()
            viewModelProducer.generateColor()
        }
    }

    private fun startFragmentReceiver() {
        requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, FragmentReceiver.newInstance())
            .addToBackStack(null)
            .commit()
    }

    companion object {
        fun newInstance() = FragmentProducer()
    }
}