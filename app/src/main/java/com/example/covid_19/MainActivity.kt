package com.example.covid_19

import android.content.Intent
import android.graphics.Color.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.leo.simplearcloader.SimpleArcLoader
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var tv_cases: TextView
    lateinit var tv_recovored: TextView
    lateinit var tv_critical: TextView
    lateinit var tv_active: TextView
    lateinit var tv_today_cases: TextView
    lateinit var tv_total_deaths: TextView
    lateinit var tv_today_deaths: TextView
    lateinit var tv_affected_countries: TextView
    lateinit var btn_go: Button
    lateinit var pie_chart: PieChart
    lateinit var sss: ScrollView
    lateinit var ppp: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findId()

        var inte = getIntent()


//        ppp.start()

        val queue = Volley.newRequestQueue(this)
        val url = "https://corona.lmao.ninja/v2/all/"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                setData(JSONObject(response))
            },
            {
                Toast.makeText(this,"Error connect to internet",Toast.LENGTH_LONG).show()
            })
        queue.add(stringRequest)

        btn_go.setOnClickListener { startActivity(Intent(this,ListContryActivity2::class.java)) }

    }

    private fun findId() {
       tv_cases = findViewById(R.id.tvCases)
       tv_active = findViewById(R.id.tvActive)
       tv_affected_countries = findViewById(R.id.tvAffectedCountries)
       tv_recovored = findViewById(R.id.tvRecovered)
       tv_critical = findViewById(R.id.tvCritical)
       tv_today_cases = findViewById(R.id.tvTodayCases)
       tv_today_deaths = findViewById(R.id.tvTodayDeaths)
       tv_total_deaths = findViewById(R.id.tvTotalDeaths)

       pie_chart = findViewById(R.id.piechart)
       btn_go = findViewById(R.id.btn_go)

        ppp = findViewById(R.id.main_ppp)
        sss = findViewById(R.id.main_sss)
    }

    private fun setData(data : JSONObject){
        ppp.visibility = View.GONE
        sss.visibility = View.VISIBLE

        tv_cases.text = data.getInt("cases").toString()
        tv_active.text = data.getInt("active").toString()
        tv_affected_countries.text = data.getInt("affectedCountries").toString()
        tv_recovored.text = data.getInt("recovered").toString()
        tv_critical.text = data.getInt("critical").toString()
        tv_today_cases.text = data.getInt("todayCases").toString()
        tv_today_deaths.text = data.getInt("todayDeaths").toString()
        tv_total_deaths.text = data.getInt("deaths").toString()

        pie_chart.addPieSlice(PieModel("Total Cases",tv_cases.text.toString().toFloat(),resources.getColor(R.color.cases)))
        pie_chart.addPieSlice(PieModel("Recovered",tv_recovored.text.toString().toFloat(),resources.getColor(R.color.recovered)))
        pie_chart.addPieSlice(PieModel("Deaths",tv_total_deaths.text.toString().toFloat(),resources.getColor(R.color.deaths)))
        pie_chart.addPieSlice(PieModel("Active",tv_active.text.toString().toFloat(),resources.getColor(R.color.active)))
        pie_chart.startAnimation()

    }
}