package com.example.covid_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AboutCovidActivity : AppCompatActivity() {
    lateinit var list:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_covid)

        list = findViewById(R.id.list_about_covid)
        setdate()
        list.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)

        list.adapter = AdapterAboutCovid(setdate())
    }

    private fun setdate():ArrayList<ItemAboutCovid> {
       var list_item_abuot_covid = ArrayList<ItemAboutCovid>()

        list_item_abuot_covid.add(ItemAboutCovid(getString(R.string.mask), R.drawable.boy))
        list_item_abuot_covid.add(ItemAboutCovid(getString(R.string.fasle), R.drawable.social))
        list_item_abuot_covid.add(ItemAboutCovid(getString(R.string.eys), R.drawable.donottouch))
        list_item_abuot_covid.add(ItemAboutCovid(getString(R.string.dast), R.drawable.washinghands))
        list_item_abuot_covid.add(ItemAboutCovid(getString(R.string.zedofoni), R.drawable.antiseptic))

        return list_item_abuot_covid
    }
}