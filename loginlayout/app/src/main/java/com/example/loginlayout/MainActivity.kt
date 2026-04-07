package com.example.loginlayout

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var etLogin: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnInicioSesion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enlace de los elementos del XML con las variables por su id
        etLogin       = findViewById(R.id.etLogin)
        etPassword    = findViewById(R.id.etPassword)
        btnInicioSesion = findViewById(R.id.btnInicioSesion)

        // Listener del botón de inicio de sesión
        btnInicioSesion.setOnClickListener {
            val usuario    = etLogin.text.toString().trim()
            val contrasena = etPassword.text.toString().trim()

            // Validación básica de campos vacíos
            if (usuario.isEmpty()) {
                etLogin.error = "El usuario no puede estar vacío"
                return@setOnClickListener
            }
            if (contrasena.isEmpty()) {
                etPassword.error = "La contraseña no puede estar vacía"
                return@setOnClickListener
            }

            // Lógica de login
            if (usuario == "admin" && contrasena == "1234") {
                Toast.makeText(this, "¡Bienvenido, $usuario!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}