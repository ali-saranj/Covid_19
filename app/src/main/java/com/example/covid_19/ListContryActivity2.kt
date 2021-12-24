package com.example.covid_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class ListContryActivity2 : AppCompatActivity() {

    lateinit var contrys: ArrayList<contry>
    lateinit var list: RecyclerView
    var img_flag: String? = null
    var name_contry: String? = null
    var cases = 0
    var today_cases = 0
    var deaths = 0
    var today_deaths = 0
    var recovered = 0
    var today_recovered = 0
    var active = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_contry)

        list = findViewById(R.id.list)

        contrys = ArrayList()

        val queue = Volley.newRequestQueue(this)
        val url = "https://corona.lmao.ninja/v2/countries/"

        val stringRequest = StringRequest(Request.Method.GET, url,
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
                list.layoutManager = LinearLayoutManager(this)
                list.adapter = CustomAdapter(contrys)
            }, { Toast.makeText(this,"Error connect to internet",Toast.LENGTH_LONG).show() })
        queue.add(stringRequest)



    }
}