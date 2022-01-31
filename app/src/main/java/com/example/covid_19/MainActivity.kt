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
import java.text.NumberFormat

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
                btn_go.isEnabled = true
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
        var numberf = NumberFormat.getInstance()

        ppp.visibility = View.GONE
        sss.visibility = View.VISIBLE



        tv_cases.text = numberf.format(data.getInt("cases"))
        tv_active.text = numberf.format(data.getInt("active"))
        tv_affected_countries.text = numberf.format(data.getInt("affectedCountries"))
        tv_recovored.text = numberf.format(data.getInt("recovered"))
        tv_critical.text = numberf.format(data.getInt("critical"))
        tv_today_cases.text = numberf.format(data.getInt("todayCases"))
        tv_today_deaths.text = numberf.format(data.getInt("todayDeaths"))
        tv_total_deaths.text = numberf.format(data.getInt("deaths"))

        pie_chart.addPieSlice(PieModel("Total Cases",data.getInt("cases").toFloat(),resources.getColor(R.color.cases)))
        pie_chart.addPieSlice(PieModel("Recovered",data.getInt("recovered").toFloat(),resources.getColor(R.color.recovered)))
        pie_chart.addPieSlice(PieModel("Deaths",data.getInt("deaths").toFloat(),resources.getColor(R.color.deaths)))
        pie_chart.addPieSlice(PieModel("Active",data.getInt("active").toFloat(),resources.getColor(R.color.active)))
        pie_chart.startAnimation()

    }
}