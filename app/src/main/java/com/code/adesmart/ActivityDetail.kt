package com.code.adesmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ActivityDetail : AppCompatActivity() {

    private var title: String = "Product Detail"

    companion object{
        const val EXTRA_NAME ="extra_name"
        const val EXTRA_DESCRIPTION ="extra_description"
        const val EXTRA_IMAGE ="extra_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailName:TextView= findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView= findViewById(R.id.tv_detail_description)
        val imgDetail :ImageView= findViewById(R.id.img_detail_image)

        val name= intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val photo   = intent.getIntExtra(EXTRA_IMAGE,0)

        tvDetailName.text = name
        tvDetailDescription.text = description

        Glide.with(this@ActivityDetail).asBitmap()
            .load(photo)
            //.apply()
            .into(imgDetail)

        setActionBarTitle(title)
    }

//    set title
    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}