package com.example.modultwo.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.modultwo.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var signin: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signin = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(signin.root)

        signin.ButtonSugnIn.setOnClickListener {

            val email: String = signin.Email.text.toString()
            val password: String = signin.Password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                if (checkEmail(email) == true) {
                    if (password.length >= 8 && password.length <= 20) {
                        startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                    } else {
                        Toast.makeText(
                            this@SignInActivity,
                            "Пароль должен содержать не менее 8 и не более 20 символов",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this@SignInActivity,
                        "Неверный адрес электронной почты",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(this@SignInActivity, "Пустые поля", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun checkEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}