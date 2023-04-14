package com.example.androidbeginner

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class MoveWithObjectActivity : AppCompatActivity() {

    // Untuk menerima object yang dikirimkan
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject: TextView = findViewById(R.id.tv_object_received)

        val person = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<PersonDataClass>(EXTRA_PERSON, PersonDataClass::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<PersonDataClass>(EXTRA_PERSON)
        }

        if (person != null){
            val text = """
                Nama : ${person.name.toString()}
                Email : ${person.email}
                Age : ${person.age}
                Location : ${person.city}
            """.trimIndent()

            tvObject.text = text
        }

    }
}