// ImageAdapter takes in the list which has images and the names that need to be displayed
// Then puts the images and texts in the grid view of HomeFragment

package com.example.readrover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ImageAdapter(private val context: HomeFragment, private val imageList: List<ImageItem>) : BaseAdapter() {
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



        val view: View = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.grid_item, parent, false)
        /* Since you're using a Fragment instead of an Activity,
        context should be obtained using parent?.context instead of passing context directly from Activity. */


        val imageView: ImageView = view.findViewById(R.id.imageView)
        val imageName: TextView = view.findViewById(R.id.imageName)
        val item = imageList[position]


        //imageView.setImageResource(item.imageResId)
        //item.imageResId?.let { imageView.setImageResource(it) }

        //Depending on the datatype of the images (int/bitmap)
        //imageView.setImageBitmap or imageView.setImageResource is used
        if (item.imageBitmap != null) {
            imageView.setImageBitmap(item.imageBitmap)
        } else if (item.imageResId != null) {
            imageView.setImageResource(item.imageResId)
        }

        imageName.text = item.imageName

        return view
    }
}
