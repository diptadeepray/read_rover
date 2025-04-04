// ImageAdapter takes in the list which has images and the names that need to be displayed
// Then puts the images and texts in the grid view of HomeFragment

package com.example.readrover

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

import android.content.Context
import android.graphics.Bitmap
import android.widget.Toast
import androidx.fragment.app.Fragment

class ImageAdapter(
    private val fragment: HomeFragment,

    private val imageList: List<ImageItem>
    //While calling ImageAdapter such variables must be passed



) : BaseAdapter() {
//centext is HomeFragment instead of Context

    override fun getCount(): Int {
        return imageList.size
    }

    override fun getItem(position: Int): Any {
        return imageList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val context = fragment.requireContext()

        val view: View = convertView ?: LayoutInflater.from(parent?.context)
            .inflate(R.layout.grid_item, parent, false)
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val imageName: TextView = view.findViewById(R.id.imageName)

        val item = imageList[position]

        if (item.imageBitmap != null) {
            imageView.setImageBitmap(item.imageBitmap)


            view.setOnClickListener {
                val intent = Intent(context, DisplayBook::class.java)

                val dbHelper = MyDatabaseHelper(context)



                val imageNameWithoutExtension = item.imageName.substringBefore(".jpg")


                val (exists,  userData) = dbHelper.userByTitle(imageNameWithoutExtension)




               if (exists && userData != null) {
                    val (author, description, genre) = userData



                   intent.putExtra("Name", imageNameWithoutExtension)
                    intent.putExtra("Author", author)
                    intent.putExtra("Description", description)
                    intent.putExtra("Genre", genre)


                }

                if(exists==null)
                {Toast.makeText(context, "Not Exist", Toast.LENGTH_SHORT).show()
                }
                else if (userData==null)
                {
                    Toast.makeText(context, "No data", Toast.LENGTH_SHORT).show()

                }

                else { Toast.makeText(context, "All there", Toast.LENGTH_SHORT).show()
                }

                context.startActivity(intent)
            }


        } else if (item.imageResId != null) {
            imageView.setImageResource(item.imageResId)
        }
        imageName.text = item.imageName




        return view


    }
}

