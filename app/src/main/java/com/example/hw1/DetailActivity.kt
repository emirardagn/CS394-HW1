package com.example.hw1

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


class DetailActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val person = intent.getSerializableExtra("person", Person::class.java) as Person

        findViewById<TextView>(R.id.nameDetail).text = person.name
        findViewById<TextView>(R.id.surnameDetail).text = person.lastname
        findViewById<TextView>(R.id.ethDetail).text = person.eth
        findViewById<TextView>(R.id.btcDetail).text = person.btc
        findViewById<TextView>(R.id.idDetail).text = person.id
        val profileImageView = findViewById<ImageView>(R.id.profilePictureDetail)


        Picasso.get()
            .load(person.profile_picture)

            .into(profileImageView)
    }
}
