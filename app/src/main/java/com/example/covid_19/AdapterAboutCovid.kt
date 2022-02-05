package com.example.covid_19

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class AdapterAboutCovid(private val dataSet: ArrayList<ItemAboutCovid>) :
    RecyclerView.Adapter<AdapterAboutCovid.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        lateinit var tv_text:TextView
        lateinit var img:ImageView
        init {

            tv_text = view.findViewById(R.id.tv_item_about_covid)
            img = view.findViewById(R.id.img_item_about_covid)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.custom_item_about_covid, viewGroup, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_text.text = dataSet[position].text
        holder.img.setImageResource(dataSet[position].img)
    }

}