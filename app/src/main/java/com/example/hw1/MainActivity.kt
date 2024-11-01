package com.example.hw1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val personList = loadCSVData()


        val adapter = PersonAdapter(personList) { person ->

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("person", person)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }


    fun loadCSVData(): List<Person> {
        val personList = mutableListOf<Person>()
        val inputStream = assets.open("MOCK_DATA.csv")
        inputStream.bufferedReader().useLines { lines ->
            lines.forEach {
                val data = it.split(",")
                val person = Person(data[0], data[1], data[2], data[3], data[4], data[5])
                personList.add(person)
                print(person.name)
            }
        }
        return personList
    }
}
