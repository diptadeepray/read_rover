/* Storing in drawable is not possible at runtime because the res/drawable folder is read-only after compilation.
Instead, images should be stored in internal storage (/data/data/<package>/files) or app-specific external storage (Android/data/<package>/files/Pictures/).
Use SharedPreferences or a Database to keep track of uploaded images.*/

package com.example.readrover

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import java.io.File
import java.io.FileOutputStream
import android.provider.MediaStore
import android.provider.OpenableColumns
import java.io.InputStream

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.Spinner

import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity


class UploadNewBook : AppCompatActivity() {

    private lateinit var btnUpload: Button
    private lateinit var btnSubmit: Button
    private lateinit var imgName: EditText
    private lateinit var photoImageView: ImageView
    private val imageList = ArrayList<String>() // Stores image paths
    private lateinit var adapter: ArrayAdapter<String>

    companion object {
        private const val PICK_IMAGE_REQUEST = 1
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_book)




        //gridView = findViewById(R.id.gridView)

        imgName = findViewById(R.id.book_title)
        this.photoImageView = findViewById(R.id.newBook_imageView)
        btnUpload = findViewById(R.id.buttonSelectImage)
        btnSubmit = findViewById(R.id.buttonAddBook)




        //Loading previous images
        val sharedPrefs = getSharedPreferences("ImagePrefs", MODE_PRIVATE)
        val savedPaths = sharedPrefs.getStringSet("images", emptySet()) ?: emptySet()
        imageList.clear()
        imageList.addAll(savedPaths)




        val spinner: Spinner = findViewById(R.id.book_spinner)

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.dropdown_items,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }












        // Handle item selection
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                Toast.makeText(
                    this@UploadNewBook,
                    "Selected: $selectedItem",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }

        }





        btnSubmit.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Close UploadNewBook so user can't go back

        }


        btnUpload.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                // Lets users select a file (image) while giving access permission to the app.

                type = "image/*"
                // Ensures that only images are shown in the file picker.

                addCategory(Intent.CATEGORY_OPENABLE)
                // Ensures the user selects a file that can be opened.
            }

            startActivityForResult(intent, PICK_IMAGE_REQUEST)
            // What Happens When startActivityForResult(intent, PICK_IMAGE_REQUEST) is Called?
        }
    }






    //this function is called after the uploading is done
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Toast.makeText(this, "Activity ends", Toast.LENGTH_SHORT).show()


        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK)
        {
            data?.data?.let { uri ->
                /*When the user selects an image from the gallery, Android does not give the actual file path.
                  Instead, it provides a content URI (Uniform Resource Identifier),
                  which acts as a reference to the image stored in the gallery or any other app.*/




                val fileName = imgName.text.toString()
                if (fileName.isNotBlank()) {

                    saveImageToInternalStorage(uri, fileName)
                    //Image saved to Internal Storage

                    photoImageView.setImageURI(uri)
                    //Displaying the image in the image view of the activity
                                           }
                            }

        }
    }






    private fun saveImageToInternalStorage(uri: Uri, fileName: String):File {

        val inputStream: InputStream? = contentResolver.openInputStream(uri)
        //Opens an input stream to read the selected image byte by byte from the URI..
        //The Uri represents the image selected from the gallery.
        //This method returns null if the image cannot be opened.

        //Suppose the user selects an image from the gallery.
        //The input stream will read data from this URI.
        //Uri: content://media/external/images/media/100

        val file = File(filesDir, "${fileName}.jpg")
        //.jpeg was not given previously, only fileName was passesd
        //And the image was not getting saved as an image
        //So when we were searching for images-to display names/display images itself-no images were found

        //val file = File(filesDir, "image_${System.currentTimeMillis()}.jpg")  // Creates a unique filename
        //Creates a new file inside the app’s internal storage directory (/data/data/<package_name>/files/).
        //filesDir is the internal storage directory of your app (/data/data/com.yourappname/files/).
        //This data cannot be accessed by other apps.
        //${System.currentTimeMillis()} Prevents accidental overwriting of images.

        val outputStream = FileOutputStream(file)
        //FileOutputStream(file) allows us to directly write to this file.

        inputStream?.copyTo(outputStream)  // Copy image data
                //Writes the image data from the input stream to the output file.


        inputStream?.close()  // Close input stream
        outputStream.close()  // Close output stream

        return file
        //returns a File object representing the saved image.
    }
}













/*
In Android, internal storage refers to the private storage space of an app.
Any files saved here cannot be accessed by other apps unless explicitly shared.
When saving an image to internal storage, we:
1 et the image URI (when the user selects an image from the gallery).
2 Read the image data using InputStream.
3 Create a new file in the app’s internal storage.
Write the image data to that file using FileOutputStream.
Close the streams to free resources.

Return the file path, so we can access it later.
If we do not return the File object, so accessing the saved image later is difficult.




 */