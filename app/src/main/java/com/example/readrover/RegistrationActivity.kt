//Everytime you add an activity you have to add it in AndroidManifest.xml file

//Shared Preference is used, to have persistent data
/*When you add values to a mutable list in Kotlin and then
restart the app, the values disappear because the list is stored in RAM (Random Access Memory).
When the app is closed or restarted, all data stored in RAM is lost.*/

//EncryptedSharedPrererence is not used for login credentials
// because the credentials are not sensitive information for working of the application

//Shared Preference works in key-value pair + lightwiight
//SQLite, Room would be heavywight(requires more RAM, processing power) for such lightweight jobs


package com.example.readrover

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


import com.example.readrover.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)



        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)


        val sharedPref = getSharedPreferences("UserData", Context.MODE_PRIVATE)


        btnSubmit.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
                /*The return@setOnClickListener statement ensures that the function execution stops
                and exits from the setOnClickListener lambda when a specific condition is met.*/
            }
            else {
                if (password != confirmPassword) {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener/*The return@setOnClickListener statement ensures that the function execution stops
                and exits from the setOnClickListener lambda when a specific condition is met.*/
                }

                else
                {
                    val editor = sharedPref.edit()
                    editor.putString(username,password)
                    editor.apply() // Save changes

                    Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()  // Close RegistrationActivity so user can't go back

                }

            }

        }

    }
}
