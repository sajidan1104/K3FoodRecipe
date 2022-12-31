package co.id.uinsgd.kel3foodrecipe.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.id.uinsgd.kel3foodrecipe.R
import kotlinx.android.synthetic.main.activity_about.*

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        buttonb.setOnClickListener(){
            finish()
        }
    }
}