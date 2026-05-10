package com.example.firstapk

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // Ajuste de insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.headerView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(0, systemBars.top, 0, 0)
            insets
        }

        // Obtener el nombre de usuario del Intent
        val usuario = intent.getStringExtra("USUARIO") ?: "Usuario"
        val tvBienvenida = findViewById<TextView>(R.id.tvBienvenida)
        
        // Usar el recurso de string con el nombre del usuario
        tvBienvenida.text = getString(R.string.home_title, usuario)

        // Configurar RecyclerView
        val rvTutorial = findViewById<RecyclerView>(R.id.rvTutorial)
        rvTutorial.layoutManager = LinearLayoutManager(this)

        // Datos del tutorial de Kotlin (puedes añadir más contenido aquí)
        val listaTutorial = listOf(
            TutorialItem("Variables y Tipos", "Diferencia entre 'val' (inmutable) y 'var' (mutable)."),
            TutorialItem("Funciones Compactas", "Aprende a escribir funciones en una sola línea."),
            TutorialItem("Estructura 'When'", "La versión potente y moderna del switch de Java."),
            TutorialItem("Null Safety", "Evita el famoso NullPointerException con '?'."),
            TutorialItem("Listas y Colecciones", "Manejo eficiente de datos con List, Set y Map."),
            TutorialItem("Corrutinas", "Introducción a la programación asíncrona en Kotlin."),
            TutorialItem("Extension Functions", "Añade funcionalidad a clases existentes sin herencia.")
        )

        val adapter = TutorialAdapter(listaTutorial)
        rvTutorial.adapter = adapter
    }
}