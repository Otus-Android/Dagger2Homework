package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.DaggerFragmentComponentReceiver
import ru.otus.daggerhomework.di.FragmentComponentProduser
import ru.otus.daggerhomework.di.FragmentComponentReceiver
import javax.inject.Inject

class FragmentReceiver : Fragment() {
    lateinit var componentReceiver: FragmentComponentReceiver
    private lateinit var navController: NavController
    @Inject
    lateinit var factoryReceiver: ViewModelReceiver.FactoryReceiver
    private lateinit var viewModelReceiver :ViewModelReceiver
    private lateinit var frame: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        componentReceiver = DaggerFragmentComponentReceiver.factory()
            .create((requireActivity() as MainActivity).appComponent)
        componentReceiver.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelReceiver=   ViewModelProviders.of(this,factoryReceiver).get(ViewModelReceiver::class.java)
        frame = view.findViewById(R.id.frame)
        navController = findNavController()
        view.findViewById<Button>(R.id.button).setOnClickListener {
            navController.navigate(R.id.action_fragmentReceiver_to_fragmentProducer)
        }
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModelReceiver.receiverStateFlow.collect {
                populateColor(it)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentReceiver", "Destory")
    }

    override fun onStop() {
        super.onStop()

    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}