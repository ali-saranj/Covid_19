package com.example.covid_19

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class G : Application() {

    var img_flag: String? = null
    var name_contry: String? = null
    var cases = 0
    var today_cases = 0
    var deaths = 0
    var today_deaths = 0
    var recovered = 0
    var today_recovered = 0
    var active = 0

    companion object{
        lateinit var context: Context
        lateinit var contrys: ArrayList<contry>
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        val queue = Volley.newRequestQueue(this)
        val url = "https://corona.lmao.ninja/v2/countries/"

        contrys = ArrayList()

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                var jsonArray = JSONArray(response)
                for (a in 0 until jsonArray.length()){
                    var jsonObject  = jsonArray.getJSONObject(a)

                    cases = jsonObject.getInt("cases")
                    recovered = jsonObject.getInt("recovered")
                    deaths = jsonObject.getInt("deaths")
                    today_cases = jsonObject.getInt("todayCases")
                    today_recovered = jsonObject.getInt("todayRecovered")
                    today_deaths = jsonObject.getInt("todayDeaths")
                    active = jsonObject.getInt("active")
                    name_contry = jsonObject.getString("country")
                    img_flag = jsonObject.getJSONObject("countryInfo").getString("flag")

                    contrys.add(contry(img_flag,name_contry,cases,today_cases,deaths,today_deaths,recovered,today_recovered,active))
                }

            }, { Toast.makeText(this,"Error connect to internet", Toast.LENGTH_LONG).show() })
        queue.add(stringRequest)
    }

}