package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    companion object {
        fun crete(
//            applicationComponent: ApplicationComponent,
              activityComponent: MainActivityComponent
        ) =
            DaggerFragmentProducerComponent.builder()
//                .applicationComponent(applicationComponent)
                .mainActivityComponent(activityComponent)
                .build()

    }
//
//    @ActivityContext
//    fun provideApplicationContext(): Context

    fun inject(fragment: FragmentProducer)

}
//@Module
//interface ProducerModule {
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(ViewModelReceiver::class)
//    abstract fun bindViewModelReceiver(viewModelProducer: ViewModelReceiver): ViewModel
//
//
//    @Singleton
//    @Binds
//    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
//}