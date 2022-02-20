package com.example.covid_19

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class TestCoivdActivity : AppCompatActivity() {
    lateinit var tv_question:TextView
    lateinit var btn_yes:Button
    lateinit var btn_no:Button
    lateinit var btn_back:ImageView
    lateinit var array: Array<String>
    var rent=0
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_coivd)

        findid()

        array = resources.getStringArray(R.array.covid_test_array)

        tv_question.text = array[i]

        btn_no.setOnClickListener {
            if (i>=(array.size-1)){
                showDialoga()
            }else{
                i++
                tv_question.text = array[i]
            }
        }

        btn_yes.setOnClickListener {
            if (i>=(array.size-1)){
                showDialoga()
            }else{
                i++
                tv_question.text = array[i]
                rent++
            }
        }

        btn_back.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(applicationContext,android.R.anim.fade_in))
            finish()
        }

    }

    private fun showDialoga() {
        var text =""

        when{
            rent<2 ->{
                text = resources.getString(R.string.ehtmalcam)
            }
            rent in 2..4 ->{
                text = resources.getString(R.string.ehtmalmotovaset)
            }
            rent in 4..8 ->{
                text = resources.getString(R.string.ehtmalziad)
            }
            rent in 8 until 10 ->{
                text = resources.getString(R.string.ehtmalglyziad)
            }
            else->{

            }
        }
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle(resources.getString(R.string.natige_coroma))
        dialog.setMessage(text)
        dialog.setCancelable(false)
        dialog.setNeutralButton(R.string.yes, DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
            finish()
        })
        dialog.create().show()
    }


    private fun findid() {
        tv_question = findViewById(R.id.tv_test_covid_question)
        btn_no = findViewById(R.id.btn_test_covid_no)
        btn_yes = findViewById(R.id.btn_test_covid_yes)
        btn_back = findViewById(R.id.btn_back_test_covid)
    }
}