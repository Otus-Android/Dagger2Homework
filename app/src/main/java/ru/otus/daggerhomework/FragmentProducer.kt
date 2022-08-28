package ru.otus.daggerhomework

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import javax.inject.Inject

class FragmentProducer : Fragment() {

  @Inject
  lateinit var viewModelProducer: ViewModelProducer

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    (activity as MainActivity).getActivityComponent()?.fragmentProducerComponentFactory()?.create()?.inject(this)
    Log.d("asdf", "activity component ${(activity as MainActivity).getActivityComponent()!!.getStateFlow()}")
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
    viewModelProducer.generateColor()
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    viewModelProducer.clear()
  }
}