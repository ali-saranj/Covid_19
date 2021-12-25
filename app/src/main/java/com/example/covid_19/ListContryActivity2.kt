package com.example.covid_19

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.core.widget.addTextChangedListener
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
    lateinit var edt_search: EditText

    lateinit var customAdapter: CustomAdapter

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
        edt_search = findViewById(R.id.edt_search)

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
                customAdapter = CustomAdapter(contrys)
                list.adapter = customAdapter
            }, { Toast.makeText(this,"Error connect to internet",Toast.LENGTH_LONG).show() })
        queue.add(stringRequest)

        edt_search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            @SuppressLint("NotifyDataSetChanged")
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                customAdapter = CustomAdapter(contry.filter(s.toString(),contrys))
                list.adapter = customAdapter
            }
            override fun afterTextChanged(s: Editable) {}
        })

    }

}