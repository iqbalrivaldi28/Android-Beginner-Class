package com.example.androidbeginner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Intent
        val btnMoveActivity: Button = findViewById(R.id.move_activity)
        btnMoveActivity.setOnClickListener(this)

        // Intent With Data
        val btnMoveWithData: Button = findViewById(R.id.move_activity_data)
        btnMoveWithData.setOnClickListener(this)

        // Intent With Object
        val btnMoveWithObject: Button = findViewById(R.id.move_activity_object)
        btnMoveWithObject.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.move_activity -> {
                val moveIntent = Intent(this@MainActivity, MainActivityMove::class.java)
                startActivity(moveIntent)
            }

            R.id.move_activity_data -> {
                val moveIntentData = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveIntentData.putExtra(MoveWithDataActivity.EXTRA_NAME, "Khanedy")
                moveIntentData.putExtra(MoveWithDataActivity.EXTRA_AGE, 17)
            }

            R.id.move_activity_object -> {
                val person = PersonDataClass(
                    "Khanedy Zain",
                    3,
                    "khan@gmail.com",
                    "Jakarta"
                )
                val moveIntentObject = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveIntentObject.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveIntentObject)
            }

        }
    }


}