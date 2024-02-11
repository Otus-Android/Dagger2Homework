package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.DaggerFragmentReceiverComponent
import ru.otus.daggerhomework.di.FragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModelFactory: ViewModelReceiverFactory
    private lateinit var viewModel: ViewModelReceiver

    private lateinit var component: FragmentReceiverComponent

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component =
            DaggerFragmentReceiverComponent.factory()
                .create((requireActivity() as MainActivity).stateDependency)
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory = component.getViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[ViewModelReceiver::class.java]
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
        viewModel.colorLiveData.observe(viewLifecycleOwner) {
            if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
            Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
            populateColor(it)
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}
