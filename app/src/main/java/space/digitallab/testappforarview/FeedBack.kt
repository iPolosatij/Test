package space.digitallab.testappforarview

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FeedBack : AppCompatActivity() {

    lateinit var rating: RatingBar
    lateinit var text: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feed_back)

        rating = findViewById(R.id.ratingBar)
        text = findViewById(R.id.textView)
        button = findViewById(R.id.button)
    }
}