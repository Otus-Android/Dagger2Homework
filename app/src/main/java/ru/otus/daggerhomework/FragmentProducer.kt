package ru.otus.daggerhomework

import android.os.*
import android.view.*
import android.widget.*
import androidx.fragment.app.*
import javax.inject.*

class FragmentProducer : Fragment() {

    @Inject
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
        DaggerFragmentProducerComponent.factory()
            .create((requireActivity() as MainActivity).mainActivityComponent).inject(this)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onCleared()
    }
}