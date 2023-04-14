package com.example.androidbeginner

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity(), View.OnClickListener{
    // tangkap id untuk tv result
    private lateinit var tvResult: TextView

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }

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

        // Intent Implicit
        val btnIntentImplicit: Button = findViewById(R.id.btn_dial_number)
        btnIntentImplicit.setOnClickListener(this)

        // Intent Implicit SMS
        val btnIntentImplicitSMS: Button = findViewById(R.id.btn_sms_number)
        btnIntentImplicitSMS.setOnClickListener(this)

        // Intent Implicit SHARE
        val btnIntentImplicitShare: Button = findViewById(R.id.btn_share)
        btnIntentImplicitShare.setOnClickListener(this)

        // Intent Implicit View URL
        val btnIntentImplicitViewUrl: Button = findViewById(R.id.btn_viewURL)
        btnIntentImplicitViewUrl.setOnClickListener(this)


        // Intent Move For Result
        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result) // tangkap id pake variabel diatasnya
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
                startActivity(moveIntentData)
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

            R.id.btn_dial_number -> {
                val phoneNumber = "081272347672"
                val btnDialPhone = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(btnDialPhone)
            }

            R.id.btn_sms_number -> {
                val smsNumber = "081272347672"
                val btnSMSButton = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$smsNumber"))
                btnSMSButton.putExtra("sms_body", "Asallamuallaikum")
                startActivity(btnSMSButton)
            }

            R.id.btn_share -> {
                val btnShare = Intent(Intent.ACTION_SEND)
                btnShare.setType("text/plain")
                btnShare.putExtra(Intent.EXTRA_TEXT, "Belajar bareng disini www.idn.id")
                startActivity(Intent.createChooser(btnShare, "Share Link"))
            }

            R.id.btn_viewURL -> {
                val btnShareUrl = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.idn.id"))
                startActivity(btnShareUrl)
            }

            R.id.btn_move_for_result -> {
                var btnMoveForResult = Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(btnMoveForResult)
            }
        }
    }


}