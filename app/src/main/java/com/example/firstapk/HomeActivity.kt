package com.example.firstapk

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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

        // Configurar RecyclerView (usamos mutableListOf para permitir agregar elementos)
        val listaTutorial = mutableListOf(
            TutorialItem("Variables y Tipos", "Diferencia entre 'val' (inmutable) y 'var' (mutable)."),
            TutorialItem("Funciones Compactas", "Aprende a escribir funciones en una sola línea."),
            TutorialItem("Estructura 'When'", "La versión potente y moderna del switch de Java."),
            TutorialItem("Null Safety", "Evita el famoso NullPointerException con '?'."),
            TutorialItem("Listas y Colecciones", "Manejo eficiente de datos con List, Set y Map."),
            TutorialItem("Corrutinas", "Introducción a la programación asíncrona en Kotlin."),
            TutorialItem("Extension Functions", "Añade funcionalidad a clases existentes sin herencia.")
        )

        val rvTutorial = findViewById<RecyclerView>(R.id.rvTutorial)
        rvTutorial.layoutManager = LinearLayoutManager(this)
        val adapter = TutorialAdapter(listaTutorial)
        rvTutorial.adapter = adapter

        // Lógica del Formulario de Anotaciones
        val etTitulo = findViewById<EditText>(R.id.etNotaTitulo)
        val etDesc = findViewById<EditText>(R.id.etNotaDescripcion)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarNota)

        btnGuardar.setOnClickListener {
            val titulo = etTitulo.text.toString().trim()
            val desc = etDesc.text.toString().trim()

            if (titulo.isNotEmpty() && desc.isNotEmpty()) {
                // Crear nueva anotación y añadirla al inicio de la lista
                val nuevaNota = TutorialItem(titulo, desc)
                listaTutorial.add(0, nuevaNota)
                
                // Notificar al adaptador que se insertó un elemento en la posición 0
                adapter.notifyItemInserted(0)
                // Desplazar la lista al inicio para ver la nueva nota
                rvTutorial.scrollToPosition(0)
                
                // Limpiar campos
                etTitulo.text.clear()
                etDesc.text.clear()
                
                Toast.makeText(this, "Anotación agregada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor, completa ambos campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}