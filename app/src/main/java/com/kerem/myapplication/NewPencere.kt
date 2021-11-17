package com.kerem.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_new_pencere.*
import java.lang.Exception


class NewPencere : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_pencere)

        val actionbar = supportActionBar

        actionbar!!.title = "Program"

        actionbar.setDisplayHomeAsUpEnabled(true)

        val txt =  intent.getStringExtra("txt").toString()

        db(txt)
    }

    fun db(text : String)
    {
        add_key.setVisibility(View.INVISIBLE)
        add_value.setVisibility(View.INVISIBLE)
        add_db.setVisibility(View.INVISIBLE)


        //try
        //{
            val database = this.openOrCreateDatabase("Odev" , Context.MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS  Ders_odev (key VARCHAR UNIQUE , value VARCHAR)")
            //database.execSQL("INSERT INTO Ders_odev (key,value) VALUES ('bil359' , 'Hello World from database')")
            var cursor = database.rawQuery("SELECT * FROM Ders_odev WHERE key = '${text}'" , null)

            val keyColumn = cursor.getColumnIndex("key")
            val valueColumn = cursor.getColumnIndex("value")

            var flag = false
            while(cursor.moveToNext())
            {
                value_db.text = cursor.getString(valueColumn)
                flag = true
            }

            if(flag == false)
                add_key_value(text , database)
            cursor.close()
        //}
        /*catch (e : Exception){
            e.printStackTrace()

        }*/
    }

    fun add_key_value(text : String , database : SQLiteDatabase)
    {
        add_key.setVisibility(View.VISIBLE)
        add_value.setVisibility(View.VISIBLE)
        add_db.setVisibility(View.VISIBLE)
        add_key.setText(text)

        add_db.setOnClickListener{
            database.execSQL("INSERT INTO Ders_odev (key,value) VALUES ('${add_key.text}' , '${add_value.text}')")
            finish()
        }
    }



}