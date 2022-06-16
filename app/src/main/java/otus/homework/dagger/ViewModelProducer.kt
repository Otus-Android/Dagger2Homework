package otus.homework.dagger

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelProducer @Inject constructor (
    private val colorGenerator: ColorGenerator?,
    private val context: Context,
    private val observer: MutableLiveData<Int>
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        observer.value = colorGenerator?.generateColor()
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}