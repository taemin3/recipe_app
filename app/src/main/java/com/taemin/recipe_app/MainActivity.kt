package com.taemin.recipe_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val category1 = findViewById<TextView>(R.id.category1)
        val category2 = findViewById<TextView>(R.id.category2)
        val category3 = findViewById<TextView>(R.id.category3)

        category1.setOnClickListener {
            val intent = Intent(this, koreaActivity::class.java)
            startActivity(intent)
        }
        category2.setOnClickListener {
            val intent = Intent(this, chinaActivity::class.java)
            startActivity(intent)
        }
        category3.setOnClickListener {
            val intent = Intent(this, westernActivity::class.java)
            startActivity(intent)
        }

        val myfoodBtn = findViewById<TextView>(R.id.myfoodBtn)
        myfoodBtn.setOnClickListener {
            val intent = Intent(this, MyfoodActivity::class.java)
            startActivity(intent)
        }

    }
}