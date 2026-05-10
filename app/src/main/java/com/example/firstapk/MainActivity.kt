package com.example.firstapk

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Ajuste de insets para diseño edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etUsuario = findViewById<TextInputEditText>(R.id.etUsuario)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnIngresar = findViewById<MaterialButton>(R.id.buttonIngresar)

        btnIngresar.setOnClickListener {
            val usuario = etUsuario.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (usuario.isNotEmpty() && password.isNotEmpty()) {
                // Usar recurso de string con formato
                val mensaje = getString(R.string.msg_login_success, usuario)
                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()

                // Ir al tutorial
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("USUARIO", usuario)
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.msg_empty_fields), Toast.LENGTH_SHORT).show()
            }
        }
    }
}