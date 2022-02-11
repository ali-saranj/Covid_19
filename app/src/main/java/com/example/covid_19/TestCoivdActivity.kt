package com.example.covid_19

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class TestCoivdActivity : AppCompatActivity() {
    lateinit var tv_question:TextView
    lateinit var btn_yes:Button
    lateinit var btn_no:Button
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

    }

    private fun showDialoga() {
        var text =""

        when{
            rent<2 ->{
                text = "احتمال کرونا داشتن شما خیلی کمه ولی اگر دوست دارید می توانید برای راحتی خیال خود به دکتر مراجعه کنید"
            }
            rent in 2..4 ->{
                text = "احتمال کرونا داشتن شما کمه ولی بهتره به دکتر مراجعه کنید مراجعه کنید"
            }
            rent in 4..8 ->{
                text = "احتمال کرونا داشتن شما زیاده در اولین فرست دکتر مراجعه کنید"
            }
            rent in 8 until 10 ->{
                text = "احتمال کرونا داشتن شما خیلی زیاده در اولین فرست دکتر مراجعه کنید"
            }
            else->{

            }
        }
        var dialog = AlertDialog.Builder(this)
        dialog.setTitle("نتیچه تست کرونا")
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
    }
}