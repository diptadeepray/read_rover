package com.example.readrover

import android.graphics.Bitmap

/*
Your ImageItem class is inside the package com.example.readrover.
Other files within the same package can directly access this class without needing an explicit import.

If another file is in a different package, it can still access ImageItem by importing it explicitly:
   import com.example.readrover.ImageItem

 */


//data class ImageItem(val imageResId: Int, val imageName: String)
data class ImageItem(val imageResId: Int? = null, val imageBitmap: Bitmap? = null, val imageName: String)



/*ata class: This is a special class in Kotlin that is primarily used to store data.
The compiler automatically generates useful functions like toString(), equals(), hashCode(), and copy() for data classes.
 */

/*val imageResId: Int: This is a property of the ImageItem class that holds an integer value. In Android, this typically represents a drawable resource ID (e.g., R.drawable.image1).*/
