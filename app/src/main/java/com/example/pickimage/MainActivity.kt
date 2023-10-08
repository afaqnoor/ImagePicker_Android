package com.example.pickimage

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Video.Media
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var btnTakePhoto : Button
    private lateinit var btngalleryimage: Button
    private lateinit var takeimage : ImageView
    private  var imageUri : Uri? = null
    private val pickedImage = 50
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        takeimage = findViewById(R.id.imageView)
        btngalleryimage = findViewById(R.id.btnGelleryPick)
        btngalleryimage.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickedImage)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickedImage){
            imageUri = data?.data
            takeimage.setImageURI(imageUri)
        }
    }
}