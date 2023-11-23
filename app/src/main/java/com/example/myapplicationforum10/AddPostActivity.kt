package com.example.myapplicationforum10


import android.content.Intent

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class AddPostActivity : AppCompatActivity() {

    private lateinit var imageViewSelectedImage: ImageView
    private lateinit var buttonPickImage: Button
    private lateinit var editTextPostContent: EditText
    private lateinit var buttonSubmitPost: Button

    private lateinit var imagePickerLauncher: ActivityResultLauncher<Intent>
    companion object {
        private const val STORAGE_PERMISSION_REQUEST_CODE = 123
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        imageViewSelectedImage = findViewById(R.id.imageViewSelectedImage)
        buttonPickImage = findViewById(R.id.buttonPickImage)
        editTextPostContent = findViewById(R.id.editTextPostContent)
        buttonSubmitPost = findViewById(R.id.buttonSubmitPost)

        // Initialize the image picker launcher
        imagePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                // Handle the picked image result
                val data: Intent? = result.data
                // Extract image data as needed, e.g., set it to the ImageView
                val selectedImageUri = data?.data
                imageViewSelectedImage.setImageURI(selectedImageUri)
            }
        }

        buttonPickImage.setOnClickListener {
            // Launch the image picker when the button is clicked
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            imagePickerLauncher.launch(intent)
        }

        buttonSubmitPost.setOnClickListener {
            // Get the selected image data (if needed)
            // val selectedImageData: Bitmap? = getSelectedImageData()

            // Get the post content
            val postContent = editTextPostContent.text.toString()



            showToast("Post submitted with content: $postContent")
        }

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}
