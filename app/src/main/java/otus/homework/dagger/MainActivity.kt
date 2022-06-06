package otus.homework.dagger

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.injectInto(this)
        Toast.makeText(App.appComponent.context, "context.toString()", Toast.LENGTH_LONG).show()
    }
}