package ru.otus.daggerhomework.producer

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.component.DaggerFragmentComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModel: ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val daggerFragmentComponent = DaggerFragmentComponent.create()
        daggerFragmentComponent.injectFragmentProducer(this)
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println(viewModel.getText())


//        view.findViewById<Button>(R.id.button).setOnClickListener {
//            //отправить результат через livedata в другой фрагмент
//        }
    }
}