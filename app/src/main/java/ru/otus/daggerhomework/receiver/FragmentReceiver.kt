package ru.otus.daggerhomework.receiver

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.appComponent
import javax.inject.Inject

class FragmentReceiver : Fragment(R.layout.fragment_b) {

    @Inject
    lateinit var receiverViewModelFactory: ViewModelProvider.Factory

    private val receiverViewModel by viewModels<ReceiverViewModel> { receiverViewModelFactory }

    private val frame by lazy { requireView().findViewById<View>(R.id.frame) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFragmentReceiverComponent.builder()
            .applicationComponent(requireContext().appComponent)
            .mainActivityComponent((requireActivity() as MainActivity).mainActivityComponent)
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        receiverViewModel.observeColors(viewLifecycleOwner) { frame.setBackgroundColor(it) }
    }
}
