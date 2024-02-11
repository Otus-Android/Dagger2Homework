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

  @Inject lateinit var vmFactory: ViewModelProviderFactory
  lateinit var vm: ViewModelProducer

  lateinit var component: FragmentProducerComponent

  override fun onAttach(context: Context) {
    super.onAttach(context)
    component =
        DaggerFragmentProducerComponent.factory()
            .create((requireActivity() as MainActivity).stateDependency)
    component.inject(this)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    vmFactory = component.getViewModelFactory()
    vm = ViewModelProvider(this, vmFactory)[ViewModelProducer::class.java]
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
      vm.generateColor()
    }
  }
}
