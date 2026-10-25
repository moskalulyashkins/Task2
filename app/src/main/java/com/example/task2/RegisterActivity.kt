package com.example.task2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passInput = findViewById<EditText>(R.id.passwordInput)
        val passConfirmInput = findViewById<EditText>(R.id.passwordConfirmInput)
        val termsCheckbox = findViewById<CheckBox>(R.id.termsCheckbox)
        val registerButton = findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val pass = passInput.text.toString().trim()
            val passConfirm = passConfirmInput.text.toString().trim()

            // Проверки по заданию
            if (name.isEmpty() || email.isEmpty() || pass.isEmpty() || passConfirm.isEmpty()) {
                Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show()
            } else if (!email.contains("@")) {
                Toast.makeText(this, "Email должен содержать @", Toast.LENGTH_SHORT).show()
            } else if (pass != passConfirm) {
                Toast.makeText(this, "Пароли не совпадают!", Toast.LENGTH_SHORT).show()
            } else if (!termsCheckbox.isChecked) {
                Toast.makeText(this, "Согласитесь с условиями", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Регистрация успешна!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}