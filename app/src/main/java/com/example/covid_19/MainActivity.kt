package com.example.covid_19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    lateinit var btn_statistics:CardView
    lateinit var btn_about:CardView
    lateinit var btn_about_coid:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findid()

        btn_statistics.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(applicationContext,android.R.anim.fade_in))
            startActivity(Intent(applicationContext,AmarActivity::class.java))
        }

        btn_about.setOnClickListener {

            it.startAnimation(AnimationUtils.loadAnimation(applicationContext,android.R.anim.fade_in))
            startActivity(Intent(applicationContext,AboutMe::class.java))
        }
        btn_about_coid.setOnClickListener {

            it.startAnimation(AnimationUtils.loadAnimation(applicationContext,android.R.anim.fade_in))
            startActivity(Intent(applicationContext,AboutCovidActivity::class.java))
        }

    }

    private fun findid() {
        btn_statistics = findViewById(R.id.btn_main_statistics)
        btn_about = findViewById(R.id.btn_main_about)
        btn_about_coid = findViewById(R.id.btn_main_about_covid)
    }
}