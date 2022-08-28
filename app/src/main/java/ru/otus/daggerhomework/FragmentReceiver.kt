package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.fragment.DaggerViewModelReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {

  private lateinit var frame: View

  @Inject
  lateinit var viewModelReceiver: ViewModelReceiver

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    (activity as MainActivity).getActivityComponent()?.let {
      DaggerViewModelReceiverComponent.factory().create(it).inject(this)
    }
    return inflater.inflate(R.layout.fragment_b, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    frame = view.findViewById(R.id.frame)
    viewModelReceiver.observeColors(this::populateColor)
  }

  fun populateColor(@ColorInt color: Int) {
    frame.setBackgroundColor(color)
  }

  override fun onDestroy() {
    super.onDestroy()

  }
}