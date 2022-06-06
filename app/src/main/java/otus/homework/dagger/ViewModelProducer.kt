package otus.homework.dagger

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context
) : ViewModel() {
    @Inject
    lateinit var observer: ColorFlow

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        observer.colorObserver.value = colorGenerator.generateColor()
    }
}