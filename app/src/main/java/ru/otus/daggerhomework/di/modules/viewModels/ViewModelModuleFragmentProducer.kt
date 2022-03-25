package ru.otus.daggerhomework.di.modules.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.viewModels.ViewModelProducer
@Module
interface ViewModelModuleFragmentProducer {
    @Binds
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    fun provideViewModelProduce( viewModel: ViewModelProducer): ViewModel
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}