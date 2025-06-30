package com.example.hatdog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewInfo : AppCompatActivity() {

    lateinit var btnBack: Button
    lateinit var tvFirstName: TextView
    lateinit var tvMiddleName: TextView
    lateinit var tvLastName: TextView
    lateinit var tvEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvFirstName = findViewById<TextView>(R.id.tvFirstName)
        tvMiddleName = findViewById<TextView>(R.id.tvMiddleName)
        tvLastName = findViewById<TextView>(R.id.tvLastName)
        tvEmail = findViewById<TextView>(R.id.tvEmail)

        val bundle = intent.extras

        tvFirstName.text = bundle?.getString("firstName")
        tvMiddleName.text = bundle?.getString("middleName")
        tvLastName.text = bundle?.getString("lastName")
        tvEmail.text = bundle?.getString("email")

        btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}