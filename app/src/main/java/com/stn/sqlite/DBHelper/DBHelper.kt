package com.stn.sqlite.DBHelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.stn.sqlite.Model.Person

// 참고 : https://fflask.tistory.com/36
class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {

    companion object {
        // Database Info
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "SQLiteKotlin.db"

        // Table InfO
        private val TABLE_NAME = "Person"
        private val COOL_ID = "Id"
        private val COOL_NAME = "Name"
        private val COOL_AGE = "Age"
        private val COOL_GENDER = "Gender"
        private val COOL_MEMO = "Memo"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY = ("CREATE TABLE $TABLE_NAME ($COOL_ID STRING PRIMARY KEY, $COOL_NAME TEXT, $COOL_AGE INTEGER, $COOL_GENDER TEXT, $COOL_MEMO TEXT)")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    // Select
    val personList: List<Person>
        get() {

        }

    // CRUD
}