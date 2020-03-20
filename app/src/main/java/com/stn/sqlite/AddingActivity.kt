package com.stn.sqlite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stn.sqlite.Model.Person
import kotlinx.android.synthetic.main.activity_adding.*

class AddingActivity : AppCompatActivity() {

    internal var personInfo: List<Person> = ArrayList<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding)

        // Click to Cancel -> Activity Finish
        cancelButton.setOnClickListener {
            finish()
        }

        // Click to Save -> SQLite 'Insert'
        saveButton.setOnClickListener {
            finish()
        }

    }

}
