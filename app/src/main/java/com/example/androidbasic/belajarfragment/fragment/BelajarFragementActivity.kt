package com.example.androidbasic.belajarfragment.fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidbasic.R
import com.example.androidbasic.belajarfragment.belajarrv.RvActivity

class BelajarFragementActivity : AppCompatActivity() {

    lateinit var btn_rv: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentSatu = FragmentSatu()
        val fragment = supportFragmentManager.findFragmentByTag(FragmentSatu::class.java.simpleName)

        if(fragment !is FragmentSatu){
            supportFragmentManager.beginTransaction()
                .add(R.id.utama, fragmentSatu, FragmentSatu::class.java.simpleName)
                .commit()
        }

        btn_rv = findViewById(R.id.btn_rv)
        btn_rv.setOnClickListener {
            val rv = Intent(this@BelajarFragementActivity, RvActivity::class.java)
            startActivity(rv)
        }
    }
}