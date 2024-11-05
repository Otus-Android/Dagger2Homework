package ru.otus.daggerhomework

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.ColorInt
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.databinding.FragmentBBinding
import javax.inject.Inject

class FragmentReceiver : BaseFragment<FragmentBBinding>() {

    @Inject
    lateinit var viewModel: ViewModelReceiver

    override fun getViewBinding() = FragmentBBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentReceiverComponent.getFragmentReceiverComponent((requireActivity() as MainActivity).activityComponent)
            .inject(this)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.colorState.collect{ color ->
                    Log.d("TAG", "onViewCreated: $color")
                    populateColor(color)
                }
            }
        }

        viewModel.init()
    }

    private fun populateColor(@ColorInt color: Int) {
        binding.frame.setBackgroundColor(color)
    }

    override fun onDestroy() {
        viewModel.cancel()
        super.onDestroy()
    }
}