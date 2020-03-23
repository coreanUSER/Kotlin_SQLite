package com.stn.sqlite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stn.sqlite.DBHelper.DBHelper
import com.stn.sqlite.Model.Person
import kotlinx.android.synthetic.main.activity_adding.*

class AddingActivity : AppCompatActivity() {

    private lateinit var db:DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adding)

        db = DBHelper(this)

        // Click to Cancel -> Activity Finish
        cancelButton.setOnClickListener {
            finish()
        }

        // Click to Save -> SQLite 'Insert' -> Activity Finish
        saveButton.setOnClickListener {
            val person = Person(
                edt_name.toString(),
                Integer.parseInt(edt_age.toString()) ,
                radioGroup.checkedRadioButtonId.toString(),
                edt_memo.toString()
            )
            db.addPerson(person)
            finish()
        }

    }

}
