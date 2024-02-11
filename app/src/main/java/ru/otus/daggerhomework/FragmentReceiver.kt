package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class FragmentReceiver : Fragment() {

  private lateinit var frame: View

  @Inject lateinit var vmFactory: ViewModelReceiverFactory
  lateinit var vm: ViewModelReceiver

  lateinit var component: FragmentReceiverComponent

  override fun onAttach(context: Context) {
    super.onAttach(context)
    component =
        DaggerFragmentReceiverComponent.factory()
            .create((requireActivity() as MainActivity).stateDependency)
    component.inject(this)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    vmFactory = component.getViewModelFactory()
    vm = ViewModelProvider(this, vmFactory)[ViewModelReceiver::class.java]
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
    vm.colorLiveData.observe(viewLifecycleOwner) { populateColor(it) }
  }

  private fun populateColor(@ColorInt color: Int) {
    frame.setBackgroundColor(color)
  }
}
