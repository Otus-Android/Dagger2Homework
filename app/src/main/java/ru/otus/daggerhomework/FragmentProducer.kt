package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.FragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory
    private lateinit var viewModel: ViewModelProducer

    private lateinit var component: FragmentProducerComponent

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component =
            DaggerFragmentProducerComponent.factory()
                .create((requireActivity() as MainActivity).mainActivityComponent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory = component.getViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[ViewModelProducer::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через livedata в другой фрагмент
            viewModel.generateColor()
        }
        viewModel.colorLiveData.observe(viewLifecycleOwner) {
            if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
            Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        }
    }
}
