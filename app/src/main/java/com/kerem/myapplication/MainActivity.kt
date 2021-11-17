package com.kerem.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val database = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar!!.title = "Program"

    }

    fun ara(view : View)
    {
        val intent = Intent(this, NewPencere::class.java)
        intent.putExtra("txt", searchKey.text.toString())
        startActivity(intent)
    }

}