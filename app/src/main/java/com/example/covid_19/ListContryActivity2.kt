package com.example.covid_19

import android.annotation.SuppressLint
import android.location.GnssAntennaInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
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

        Toast.makeText(this,resources.getString(R.string.toast_activity_list), Toast.LENGTH_SHORT).show()

        contrys = ArrayList()

        list.layoutManager = LinearLayoutManager(this)
        customAdapter = CustomAdapter(G.contrys)
        list.adapter = customAdapter

        edt_search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            @SuppressLint("NotifyDataSetChanged")
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                customAdapter = CustomAdapter(contry.filter(s.toString(),G.contrys))
                list.adapter = customAdapter
            }
            override fun afterTextChanged(s: Editable) {}
        })


    }

}

