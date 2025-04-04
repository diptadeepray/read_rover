// For using view binding we have to do:- viewBinding true
// in the build.gradle file (Module level)
// Then a binding object file will be created for each XML file


//Problem is while displaying images from drawable folder
//We used int
//While displaying images from internal storage
//We have to use bitmap
//So 3 arguments are used in ImageItem instead of 2


package com.example.readrover

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import java.io.File
import android.widget.GridView
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import com.example.readrover.databinding.HomeFragmentBinding





class HomeFragment : Fragment(R.layout.settings_fragment) {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var imagesGridView: GridView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = HomeFragmentBinding.inflate(inflater, container, false)












        // Loading images from drawable folder...

        val fields = R.drawable::class.java.declaredFields
        /*The reason we use R.drawable::class.java.declaredFields is that,
in Kotlin, R.drawable is actually generated as a Java class under the hood.*/

        val imags = mutableListOf<ImageItem>()
        /* MutableList of ImageItem data type is created. The mutableList is named images.
        In the mutable list, items are added one by one.*/

        //Creates a list which has images and the names that will be displayed
        for (field in fields) {
            try {

                if (field.name.startsWith("book")) {

                    val resourceId = field.getInt(null)
                    // resourceId is a number which is used to identify the image

                    imags.add(ImageItem(imageResId = resourceId, imageName = field.name))
                    //We are specifying the arguments because the ImageItem has 3 parameters but we are passing only 2
                }}

            catch (e: Exception) {
                e.printStackTrace()
            }
        }

//We can also add the items individually in the code, but this way cannot be used for vew images so
//we have not used this way to creating a list
        /*val images = listOf(
            ImageItem(R.drawable.book1, "Image 11"),
            ImageItem(R.drawable.book2, "Image 2"),
            ImageItem(R.drawable.book3, "Image 3"),
            ImageItem(R.drawable.book4, "Image 4"),
            ImageItem(R.drawable.book5, "Image 5"),
            ImageItem(R.drawable.book6, "Image 6"),
        )*/















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
                imags.add(ImageItem(imageBitmap = bitmap, imageName = file.name))
            }
        }
        else
        {
            println("Nothing")
        }
        //And call ImageAdapter to display the images












        //Calling the Image Adapter class to show the images and names in the grid view of the list
        if (imags.isNotEmpty()) {
            //val adapter = ImageAdapter(this, imags)
            val adapter = ImageAdapter(this, imags)


            binding.gridView.adapter = adapter
        }












        binding.addBookButton.setOnClickListener {
            val intent = Intent(activity, UploadNewBook::class.java)
            startActivity(intent)
            // Doesnot end the activity so if user has mistakenly clicked on Regisreation,
            // he/she can click back and come to the login page.
        }










        return binding.root
    }












    /*private fun loadImagesFromInternalStorage(): List<File> {
        val imagesDir = context?.filesDir
        return imagesDir?.listFiles { file ->
            file.isFile && (file.name.endsWith(".jpg") || file.name.endsWith(".png"))
        }?.toList() ?: emptyList()
    }*/

    //private fun loadImagesFromInternalStorage(){
// Will return Bitmap and String Instead of just Bitmap

        /* MutableList of ImageItem data type is created. The mutableList is named images.
        In the mutable list, items are added one by one.
         */
    //}
}