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
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val imageName: TextView = view.findViewById(R.id.imageName)
        val item = imageList[position]

        if (item.imageBitmap != null) {
            imageView.setImageBitmap(item.imageBitmap)
        } else if (item.imageResId != null) {
            imageView.setImageResource(item.imageResId)
        }
        imageName.text = item.imageName
        return view
    }
}
