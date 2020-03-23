package com.stn.sqlite.DBHelper

import android.content.ContentValues
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

    // CRUD
    // Select
    val personList: List<Person>
        get() {
            val rowPerson = ArrayList<Person>()
            val selectQueryHandler = "SELECT * FROM $TABLE_NAME"
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQueryHandler, null)
            if(cursor.moveToFirst()){
                do {
                    val person = Person()
                    person.id = cursor.getString(cursor.getColumnIndex(COOL_ID))
                    person.name = cursor.getString(cursor.getColumnIndex(COOL_NAME))
                    person.age = cursor.getInt(cursor.getColumnIndex(COOL_AGE))
                    person.gender = cursor.getString(cursor.getColumnIndex(COOL_GENDER))
                    person.memo = cursor.getString(cursor.getColumnIndex(COOL_MEMO))
                    rowPerson.add(person)
                } while (cursor.moveToNext())
            }
            db.close()
            return rowPerson
        }

    // Insert
    fun addPerson(person: Person) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COOL_ID, person.id)
        values.put(COOL_NAME, person.name)
        values.put(COOL_AGE, person.age)
        values.put(COOL_GENDER, person.gender)
        values.put(COOL_MEMO, person.memo)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    // Update
    fun updatePerson(person: Person): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COOL_ID, person.id)
        values.put(COOL_NAME, person.name)
        values.put(COOL_AGE, person.age)
        values.put(COOL_GENDER, person.gender)
        values.put(COOL_MEMO, person.memo)

        return db.update(TABLE_NAME, values, "$COOL_ID=?", arrayOf(person.id))
    }

    // Delete
    fun deletePerson(person: Person) {
        val db = this.writableDatabase

        db.delete(TABLE_NAME, "$COOL_ID", arrayOf(person.id))
        db.close()
    }
}