package com.example.hatdog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUp : AppCompatActivity() {

    lateinit var btnbackToLogin: Button
    lateinit var btnSignUp: Button
    lateinit var etFirstName: EditText
    lateinit var etMiddleName: EditText
    lateinit var etLastName: EditText
    lateinit var etEmail: EditText
    lateinit var etSignUpPassword: EditText
    lateinit var etSignUpConfirmPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etFirstName = findViewById<EditText>(R.id.etFirstName)
        etMiddleName = findViewById<EditText>(R.id.etMiddleName)
        etLastName = findViewById<EditText>(R.id.etLastName)
        etEmail = findViewById<EditText>(R.id.etEmail)
        etSignUpPassword = findViewById<EditText>(R.id.etSignUpPassword)
        etSignUpConfirmPassword = findViewById<EditText>(R.id.etSignUpConfirmPassword)

        btnbackToLogin = findViewById<Button>(R.id.btnbackToLogin)
        btnbackToLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        btnSignUp = findViewById<Button>(R.id.btnSignUp)
        btnSignUp.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("firstName", etFirstName.text.toString())
            bundle.putString("middleName", etMiddleName.text.toString())
            bundle.putString("lastName", etLastName.text.toString())
            bundle.putString("email", etEmail.text.toString())
            bundle.putString("password", etSignUpPassword.text.toString())

            if(etSignUpPassword.text.toString().equals(etSignUpConfirmPassword.text.toString())){
                val intent = Intent(this, ReviewInfo::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            }

        }
    }
}