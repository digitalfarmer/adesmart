package com.code.adesmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AboutUsActivity : AppCompatActivity() {
    private var title: String = "About Us"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}