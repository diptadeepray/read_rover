package com.example.readrover

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.Intent



import android.view.View
import android.view.ViewGroup

import android.widget.Button
import android.widget.TextView

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

import com.example.readrover.databinding.HomeFragmentBinding


class HomeFragment : Fragment(R.layout.settings_fragment) {
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)


        val items = mutableListOf("Hero", "Zero", "Lion", "Helmet")




        return binding.root
    }
}