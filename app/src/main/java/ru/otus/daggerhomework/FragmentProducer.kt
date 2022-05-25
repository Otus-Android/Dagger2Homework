package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var vm: ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm = ViewModelProvider(this, viewModelFactory)[ViewModelProducer::class.java]

        view.findViewById<Button>(R.id.button).setOnClickListener {
            vm.generateColor()
            //отправить результат через livedata в другой фрагмент
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerFragmentProducerComponent
            .builder()
            .mainActivityComponent((activity as MainActivity).component)
            .build()
            .inject(this)
    }
}