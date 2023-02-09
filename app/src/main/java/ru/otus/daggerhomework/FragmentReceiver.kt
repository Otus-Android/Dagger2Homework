package ru.otus.daggerhomework

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }


    @Inject
    lateinit var receiverLiveData: LiveData<Int>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        (requireActivity() as MainActivity).mainActivityComponent.fragmentReceiverComponent().build().inject(this)

        receiverLiveData.observe(viewLifecycleOwner){
            frame.setBackgroundColor(it)
            Log.d("RECEIVE", it.toString())
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}