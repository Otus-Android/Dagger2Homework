package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.fragment.DaggerViewModelProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

  @Inject
  lateinit var viewModelProducer: ViewModelProducer

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    (activity as MainActivity).getActivityComponent()?.let {
      DaggerViewModelProducerComponent.factory().create(it).inject(this)
    }
    return inflater.inflate(R.layout.fragment_a, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    view.findViewById<Button>(R.id.button).setOnClickListener {
      //отправить результат через livedata в другой фрагмент
      viewModelProducer.generateColor()
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    viewModelProducer.clear()
  }
}