package otus.homework.dagger

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import otus.homework.dagger.di.ActivityScope
import otus.homework.dagger.di.AppScope
import javax.inject.Inject

class VMFactoryProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityScope private val context: Context,
    private val observer: MutableLiveData<Int>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ViewModelProducer::class.java)) {
            ViewModelProducer(context = context, colorGenerator = colorGenerator, observer = observer) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}

class VMFactoryReceiver @Inject constructor(
    @AppScope private val context: Context,
    private val observer: MutableLiveData<Int>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ViewModelReceiver::class.java)) {
            ViewModelReceiver(context, observer = observer) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}