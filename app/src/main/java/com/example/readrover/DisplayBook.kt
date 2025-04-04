package com.example.readrover

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DisplayBook : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_book)

        Toast.makeText(this, "Reached DisplayBook", Toast.LENGTH_SHORT).show()


        val displayName = findViewById<TextView>(R.id.display_name)
        val displayAuthor = findViewById<TextView>(R.id.display_author)
        val displayDescription = findViewById<TextView>(R.id.display_description)
        val displayGenre = findViewById<TextView>(R.id.display_genre)

        val button_done = findViewById<Button>(R.id.done_here)

        displayName.text = intent.getStringExtra("Name") ?: "No Title Found"
        displayAuthor.text = intent.getStringExtra("Author") ?: "No Author Found"
        displayDescription.text= intent.getStringExtra("Description")?: "No Description Found"
        displayGenre.text= intent.getStringExtra("Genre")?: "No Genre Found"



        button_done.setOnClickListener {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()  // Close DisplayBook user can't go back
         }
        }



        }
