package com.torchtech.customradiobutton

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val genderDisplay = findViewById<TextView>(R.id.genderDisplay)
        val radioGroup1 = findViewById<RadioGroup>(R.id.radioGroup1)
        val showButton = findViewById<Button>(R.id.showBtn)

        showButton.setOnClickListener {
            val selectedButtonId = radioGroup1.checkedRadioButtonId
            if (selectedButtonId != -1){
                val selectedButton = findViewById<RadioButton>(selectedButtonId)
                val genderName = selectedButton.text.toString()
                genderDisplay.text= getString(R.string.your_gender_is, genderName)
            } else genderDisplay.text = getString(R.string.please_select_a_gender)



        }



    }
}