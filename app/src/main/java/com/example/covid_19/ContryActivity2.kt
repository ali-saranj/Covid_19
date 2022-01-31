package com.example.covid_19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel
import java.text.NumberFormat

class ContryActivity2 : AppCompatActivity() {
    lateinit var tv_name :TextView
    lateinit var img_flag :ImageView
    lateinit var btn_back :ImageView
    lateinit var PieChart :PieChart
    lateinit var tv_cases :TextView
    lateinit var tv_cases_today :TextView
    lateinit var tv_recovered :TextView
    lateinit var tv_recovered_today :TextView
    lateinit var tv_deaths :TextView
    lateinit var tv_deaths_today :TextView
    var pozishen = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contry2)

        var names = ArrayList<String>()
        val intent = getIntent()
        G.contrys.forEach {
            names.add(it.name_contry)
        }
        pozishen = names.indexOf(intent.getStringExtra("name").toString())

        findid()
        setdata()

        btn_back.setOnClickListener{
            it.startAnimation(AnimationUtils.loadAnimation(applicationContext,android.R.anim.fade_in))
            finish()
        }
    }



    private fun findid() {
        img_flag = findViewById(R.id.img_toolbar_contry)
        tv_name = findViewById(R.id.tv_name_contry_toolbar)
        btn_back = findViewById(R.id.btn_back_contry_tool)
        PieChart = findViewById(R.id.piechart_contry2)
        tv_cases = findViewById(R.id.tv_cases_contry)
        tv_cases_today = findViewById(R.id.tv_today_case)
        tv_recovered = findViewById(R.id.tv_recovered_contry)
        tv_recovered_today = findViewById(R.id.tv_today_recovered)
        tv_deaths = findViewById(R.id.tv_deaths_contry)
        tv_deaths_today = findViewById(R.id.tv_today_deaths)
    }

    private fun setdata() {
        var numberf = NumberFormat.getInstance()
        Glide.with(applicationContext).load(G.contrys[pozishen].img_flag).into(img_flag)
        tv_name.text = G.contrys[pozishen].name_contry.toString()
        tv_recovered.text = numberf.format(G.contrys[pozishen].recovered)
        tv_recovered_today.text = numberf.format(G.contrys[pozishen].today_recovered)
        tv_cases.text = numberf.format(G.contrys[pozishen].cases)
        tv_cases_today.text = numberf.format(G.contrys[pozishen].today_cases)
        tv_deaths.text = numberf.format(G.contrys[pozishen].deaths)
        tv_deaths_today.text = numberf.format(G.contrys[pozishen].today_deaths)

        PieChart.addPieSlice(PieModel("Total Cases",G.contrys[pozishen].cases.toFloat(),resources.getColor(R.color.cases)))
        PieChart.addPieSlice(PieModel("Recovered",G.contrys[pozishen].recovered.toFloat(),resources.getColor(R.color.recovered)))
        PieChart.addPieSlice(PieModel("Deaths",G.contrys[pozishen].deaths.toFloat(),resources.getColor(R.color.deaths)))
        PieChart.addPieSlice(PieModel("Active",G.contrys[pozishen].active.toFloat(),resources.getColor(R.color.active)))
        PieChart.startAnimation()
    }
}