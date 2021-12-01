package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import ru.otus.daggerhomework.di.DaggerFragmentComponentProduser
import ru.otus.daggerhomework.di.DaggerFragmentComponentReceiver
import ru.otus.daggerhomework.di.FragmentComponentProduser
import javax.inject.Inject

class FragmentProducer : Fragment() {
    private lateinit var navController: NavController

    @Inject
    lateinit var factoryProducer: ViewModelProducer.FactoryProducer
    private val viewModelProduser by viewModels<ViewModelProducer> { factoryProducer }
    lateinit var componentProduser: FragmentComponentProduser
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        componentProduser = DaggerFragmentComponentProduser.factory()
            .create((requireActivity() as MainActivity).appComponent)
        componentProduser.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModelProduser.provideColor()
            navController.navigate(R.id.fragmentReceiver)
        }
    }
}