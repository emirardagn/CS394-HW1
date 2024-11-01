package com.example.hw1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PersonAdapter(private val personList: List<Person>, private val onItemClick: (Person) -> Unit) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {


    class PersonViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nameText: TextView = view.findViewById(R.id.nameTextView)
        val profileImage: ImageView = view.findViewById(R.id.profileImageView)

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {

        val person = personList[position]
        holder.nameText.text = person.name + " " + person.lastname

        Picasso.get()
            .load(person.profile_picture)
            .into(holder.profileImage)


        holder.itemView.setOnClickListener {
            onItemClick(person)
        }
    }

    override fun getItemCount() = personList.size
}
