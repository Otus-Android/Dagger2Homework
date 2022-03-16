package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject


class FragmentProducer @Inject constructor(context:Context,colorGenerator: ColorGenerator,publishSubject: PublishSubject<Int>) : Fragment() {


    val viewModel by viewModels<ViewModelProducer>() {
       ViewModelProducerFactory(
           colorGenerator = colorGenerator,
           context = context,
           publishSubject = publishSubject
       )
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
           viewModel.generateColor()
        }
    }



}