package com.example.readrover

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.view.View

import android.content.Intent

//This import is used, so that we can use ViewBinding
//i.e. use objects of the layouts instead of findViewById


//Importing this will not do the job
import androidx.fragment.app.Fragment

//We need to import the following
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


import android.widget.TextView
import com.example.readrover.databinding.ActivityMainBinding

import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    // If we enable binding in the build gradle file.
    // Then for every XML file a binding class is generated.
    // This binding class can be used to access the views in the XML file





    override fun onCreate(savedInstanceState: Bundle?) {

// Apply theme before calling super and loading UI
        val sharedPref = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val isDark = sharedPref.getBoolean("isDarkMode", false)

        if (isDark) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }



        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)




        val ibutton_hm: ImageView = findViewById(R.id.image_button_home)
        val ibutton_pf: ImageView = findViewById(R.id.image_button_profile)
        val ibutton_st: ImageView = findViewById(R.id.image_button_settings)

        val tbutton_hm: TextView = findViewById(R.id.text_button_home)
        val tbutton_pf: TextView = findViewById(R.id.text_button_profile)
        val tbutton_st: TextView = findViewById(R.id.text_button_settings)




        if (savedInstanceState == null) {
            val fragment = HomeFragment()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container_view, fragment)
            fragmentTransaction.addToBackStack(null) // Add to backstack for navigation //So if the user clicks on back, no screen will appear appear?
            fragmentTransaction.commit()
        }



        binding.imageButtonHome.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view, HomeFragment())
            transaction.commit()
        }

        binding.textButtonHome.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view, HomeFragment())
            transaction.commit()
        }

        /* button_hm.setOnClickListener {
             val fragment = HomeFragment()
             val fragmentManager: FragmentManager = supportFragmentManager
             val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
             fragmentTransaction.replace(R.id.fragment_container_view, fragment)
             fragmentTransaction.addToBackStack(null) // Add to backstack for navigation
             fragmentTransaction.commit()
         }*/


        ibutton_pf.setOnClickListener {
            val fragment = ProfileFragment()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container_view, fragment)
            fragmentTransaction.addToBackStack(null) // Add to backstack for navigation
            fragmentTransaction.commit()
        }

        tbutton_pf.setOnClickListener {
            val fragment = ProfileFragment()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container_view, fragment)
            fragmentTransaction.addToBackStack(null) // Add to backstack for navigation
            fragmentTransaction.commit()
        }



        ibutton_st.setOnClickListener {
            val fragment = SettingsFragment()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container_view, fragment)
            fragmentTransaction.addToBackStack(null) // Add to backstack for navigation
            fragmentTransaction.commit()
        }

        tbutton_st.setOnClickListener {
            val fragment = SettingsFragment()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container_view, fragment)
            fragmentTransaction.addToBackStack(null) // Add to backstack for navigation
            fragmentTransaction.commit()
        }



    }}




// Initially load the first fragment
/*if (savedInstanceState == null) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.home_fragment, HomeFragment())
        .commit()


// Initially load the first fragment
    if (savedInstanceState == null) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<HomeFragment>(R.id.home_fragment)


            // Button click
            //button_hm.setOnClickListener {
            //replaceFragment(HomeFragment())
        }

    }
}}


// Function to replace fragments
//private fun replaceFragment(fragment: HomeFragment) {
//supportFragmentManager.beginTransaction()
    //.replace(R.id.home_fragment, fragment)
    //.addToBackStack(null)
    //.commit()



*/