package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import javax.inject.Inject

class FragmentProducer : Fragment(R.layout.fragment_a) {

    @Inject
    lateinit var viewModelFactory : ViewModelFactory

    private val producerViewModel by lazy(LazyThreadSafetyMode.NONE) {
        viewModelFactory.create(ViewModelProducer::class.java)
    }

    override fun onAttach(context : Context) {
        super.onAttach(context)

        DaggerProducerComponent
            .factory()
            .create((requireActivity() as MainActivity).activityComponent)
            .inject(this)
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(view) {
            findViewById<Button>(R.id.button_generate_color)
                .setOnClickListener {
                    //отправить результат через livedata в другой фрагмент
                    producerViewModel.generateColor()
                }

            findViewById<Button>(R.id.button_open_receiver_fragment)
                .setOnClickListener {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FragmentReceiver())
                        .addToBackStack("FragmentProducer")
                        .commit()
                }
        }
    }
}