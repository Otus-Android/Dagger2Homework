package otus.homework.dagger

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory constructor(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ViewModelProducer::class.java)) {
            ViewModelProducer(context = context, colorGenerator = ColorGeneratorImpl()) as T
        } else if (modelClass.isAssignableFrom(ViewModelReceiver::class.java)) {
            ViewModelReceiver(context) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}