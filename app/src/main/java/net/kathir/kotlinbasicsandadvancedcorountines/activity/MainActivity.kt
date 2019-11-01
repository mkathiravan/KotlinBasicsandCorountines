package net.kathir.kotlinbasicsandadvancedcorountines.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.kathir.kotlinbasicsandadvancedcorountines.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pageAdapterView.setOnClickListener {

            startActivity(Intent(this@MainActivity,
                PageAdapterActivity::class.java))
        }

        imagefilterApply.setOnClickListener {

            startActivity(Intent(this@MainActivity,
                CricketMainActivity::class.java))
        }
    }
}
