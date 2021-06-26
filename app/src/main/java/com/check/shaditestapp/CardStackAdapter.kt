package com.check.shaditestapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CardStackAdapter (private var spots: List<ProfileShadi?>? = emptyList()
) : RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_profile_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val profileShadi = spots!![position]
        holder.name.text = profileShadi!!.id?.name
       holder.city.text = profileShadi.phone
        Glide.with(holder.image)
            .load(profileShadi.picture?.large)
            .into(holder.image)
        holder.itemView.setOnClickListener { v ->
            Toast.makeText(v.context, profileShadi.name?.first, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return spots!!.size
    }

    fun setSpots(spots: List<ProfileShadi>) {
        this.spots = spots
    }

    fun getSpots(): List<ProfileShadi?> {
        return spots!!
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.item_name)
        var city: TextView = view.findViewById(R.id.item_city)
        var image: ImageView = view.findViewById(R.id.item_image)
    }

}