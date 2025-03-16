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

import android.widget.Button
import android.widget.TextView





class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)



        val button_hm: TextView = findViewById(R.id.button_home)
        val button_rp: TextView = findViewById(R.id.button_reports)
        val button_fn: TextView = findViewById(R.id.button_financials)
        val button_pf: TextView = findViewById(R.id.button_profile)




        if (savedInstanceState == null) {
            val fragment = HomeFragment()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container_view, fragment)
            fragmentTransaction.addToBackStack(null) // Add to backstack for navigation //So if the user clicks on back, no screen will appear appear?
            fragmentTransaction.commit()
        }



        binding.buttonHome.setOnClickListener {
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


        button_rp.setOnClickListener {
            val fragment = ReportsFragment()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container_view, fragment)
            fragmentTransaction.addToBackStack(null) // Add to backstack for navigation
            fragmentTransaction.commit()
        }

        button_fn.setOnClickListener {
            val fragment = FinancialsFragment()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container_view, fragment)
            fragmentTransaction.addToBackStack(null) // Add to backstack for navigation
            fragmentTransaction.commit()
        }

        button_pf.setOnClickListener {
            val fragment = ProfileFragment()
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