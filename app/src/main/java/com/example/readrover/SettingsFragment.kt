package com.example.readrover

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build


import android.view.View
import android.view.ViewGroup

import android.widget.Button
import android.widget.TextView

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat.recreate
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

import com.example.readrover.databinding.SettingsFragmentBinding


class SettingsFragment : Fragment(R.layout.settings_fragment) {
    private lateinit var binding: SettingsFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //In a Fragment, you can't directly call getSharedPreferences() like you do in an Activity,
        // because a Fragment doesn’t inherit from Context.
        //val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val sharedPref = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)


        val isDark = sharedPref.getBoolean("isDarkMode", false)
        //Default is light

        if (isDark) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }


        binding = SettingsFragmentBinding.inflate(inflater, container, false)

        binding.themeSwitch.isChecked = isDark

        binding.themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            sharedPref.edit().putBoolean("isDarkMode", isChecked).apply()

            // Apply new theme and recreate activity
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }

            requireActivity().recreate()

            //binding.themeSwitch.isChecked=

        }
        return binding.root


    }
}

