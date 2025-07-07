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
import com.example.hatdog.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {

//    lateinit var btnbackToLogin: Button
//    lateinit var btnSignUp: Button
    private lateinit var binding: ActivitySignUpBinding
//    lateinit var etFirstName: EditText
//    lateinit var etMiddleName: EditText
//    lateinit var etLastName: EditText
//    lateinit var etEmail: EditText
//    lateinit var etSignUpPassword: EditText
//    lateinit var etSignUpConfirmPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        etFirstName = findViewById<EditText>(R.id.etFirstName)
//        etMiddleName = findViewById<EditText>(R.id.etMiddleName)
//        etLastName = findViewById<EditText>(R.id.etLastName)
//        etEmail = findViewById<EditText>(R.id.etEmail)
//        etSignUpPassword = findViewById<EditText>(R.id.etSignUpPassword)
//        etSignUpConfirmPassword = findViewById<EditText>(R.id.etSignUpConfirmPassword)


        binding.btnbackToLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }


        binding.btnSignUp.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("firstName", binding.etFirstName.text.toString())
            bundle.putString("middleName", binding.etMiddleName.text.toString())
            bundle.putString("lastName", binding.etLastName.text.toString())
            bundle.putString("email", binding.etEmail.text.toString())
            bundle.putString("password", binding.etSignUpPassword.text.toString())

            if(binding.etSignUpPassword.text.toString().equals(binding.etSignUpConfirmPassword.text.toString())){
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