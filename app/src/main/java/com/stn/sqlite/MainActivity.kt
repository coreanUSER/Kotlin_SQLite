package com.stn.sqlite

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Click Floating Action Button -> Start AddingActivity
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddingActivity::class.java)
            startActivity(intent)
        }

        
    }
}
