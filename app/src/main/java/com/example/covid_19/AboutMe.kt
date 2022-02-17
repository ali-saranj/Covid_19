package com.example.covid_19

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.lang.Exception


class AboutMe : AppCompatActivity() {

    lateinit var image_sms:ImageView
    lateinit var image_phone:ImageView
    lateinit var image_internet:ImageView
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        findid()
        ActivityCompat.requestPermissions(this@AboutMe, arrayOf(Manifest.permission.CALL_PHONE),1)


        image_phone.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(applicationContext,android.R.anim.fade_in))

            try {
                val posted_by = "09136978682"
                val uri = "tel:$posted_by"
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse(uri)
                startActivity(intent)
            }catch (e:Exception){
                ActivityCompat.requestPermissions(this@AboutMe, arrayOf(Manifest.permission.CALL_PHONE),1)
            }



        }

        image_sms.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(applicationContext,android.R.anim.fade_in))
            val email = Intent(Intent.ACTION_SEND)
            email.putExtra(Intent.EXTRA_EMAIL, arrayOf("ali.saranj1384@gmail.com"))
            email.putExtra(Intent.EXTRA_SUBJECT,"")
            email.putExtra(Intent.EXTRA_TEXT,"")
            email.type = "message/rfc822"
            startActivity(email)
        }

        image_internet.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(applicationContext,android.R.anim.fade_in))
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://alisaranj.blogfa.com/post/1")))
        }


    }

    private fun findid() {
        image_phone = findViewById(R.id.img_phone)
        image_sms = findViewById(R.id.image_sms)
        image_internet = findViewById(R.id.image_internet)
    }
}