package com.example.readrover

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.Intent
import android.graphics.BitmapFactory


import android.view.View
import android.view.ViewGroup

import android.widget.Button
import android.widget.TextView

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.readrover.DataHolder.display_username

import com.example.readrover.databinding.ProfileFragmentBinding
import java.io.File


class ProfileFragment : Fragment(R.layout.settings_fragment) {
    private lateinit var binding: ProfileFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProfileFragmentBinding.inflate(inflater, container, false)



















        val imags = mutableListOf<String>()



        // Load images from internal storage to the same list
        imags.addAll( loadImagesFromInternalStorage())
        //And call ImageAdapter to display the images

        //Calling the Image Adapter class to show the images and names in the grid view of the list
   /*     if (imags.isNotEmpty()) {
            //val adapter = ImageAdapter(this, imags)

            binding.textViewProfile.text= imags.toString()

        }*/




        val dbHelper = MyDatabaseHelper(requireContext())
        binding.displayName.text= "Hello " +display_username +"!"





        return binding.root
    }











    private fun loadImagesFromInternalStorage(): List<String> {


        val imags = mutableListOf<String>()

        // Loading images from private internal storage...

        //val images = mutableListOf<ImageItem>()
        // Creating a list of Bitmap and String Instead of just Bitmap

        //val directory = File(requireContext().filesDir)
        val directory = context?.filesDir
        //val directory = File(this.filesDir)
        //val directory = File(context?.filesDir ,"images")

        if (directory?.exists()==true) {
            val files =
                directory.listFiles { file -> file.extension == "jpg" || file.extension == "png"   }
            files?.forEach { file ->
                val bitmap = BitmapFactory.decodeFile(file.absolutePath)

                //We are specifying the arguments because the ImageItem has 3 parameters but we are passing only 2
                imags.add(file.name)
            }
        }
        else
        {
            println("Nothing")
        }





        /* MutableList of ImageItem data type is created. The mutableList is named images.
        In the mutable list, items are added one by one.
         */

        val images = mutableListOf<String>()




        if (directory?.exists()==true) {
            val files = directory?.listFiles { file -> file.extension == "jpg" || file.extension == "png" }
            files?.forEach { file ->
                val bitmap = BitmapFactory.decodeFile(file.absolutePath)

                //We are specifying the arguments because the ImageItem has 3 parameters but we are passing only 2
                images.add(file.name)
            }
        }
        return images
    }


}