package com.example.readrover

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity




class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPref = getSharedPreferences("UserData", Context.MODE_PRIVATE)


        val usernameInput = findViewById<EditText>(R.id.login_username)
        val passwordInput = findViewById<EditText>(R.id.login_password)
        val loginButton = findViewById<Button>(R.id.login_button)
        val textButton = findViewById<TextView>(R.id.clickableTextView_login)

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (sharedPref.getString(username, "No Data Found")==password) {  // Replace with real validation
                val intent = Intent(this, MainActivity::class.java)

                DataHolder.display_username=username
                startActivity(intent)
                finish()  // Close LoginActivity so user can't go back
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }

        textButton.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            // Doesnot end the activity so if user has mistakenly clicked on Regisreation,
            // he/she can click back and come to the login page.
        }


    }
}