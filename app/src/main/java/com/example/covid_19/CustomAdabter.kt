package com.example.covid_19

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlin.time.measureTimedValue


class CustomAdapter(private val dataSet: ArrayList<contry>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var tv_name_contry : TextView
        lateinit var tv_cases : TextView
        lateinit var tv_deaths : TextView
        lateinit var tv_recovered : TextView
        lateinit var img_flag : ImageView

        init {
            tv_name_contry = view.findViewById(R.id.tv_name_contry_item)
            tv_cases = view.findViewById(R.id.tv_cases_item)
            tv_recovered = view.findViewById(R.id.tv_recovered_item)
            tv_deaths = view.findViewById(R.id.tv_deaths_item)
            img_flag = view.findViewById(R.id.img_flog_item)

        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.custom_contry_list, viewGroup, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tv_name_contry.text = dataSet[position].name_contry
        viewHolder.tv_cases.text = dataSet[position].cases.toString()
        viewHolder.tv_recovered.text = dataSet[position].recovered.toString()
        viewHolder.tv_deaths.text = dataSet[position].deaths.toString()
        Glide.with(G.context).load(dataSet[position].img_flag).into(viewHolder.img_flag)
    }

    override fun getItemCount() = dataSet.size

}