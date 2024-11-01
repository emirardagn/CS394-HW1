package com.example.hw1

import java.io.Serializable

data class Person(
    val id: String,
    val name: String,
    val lastname: String,
    val btc: String,
    val eth: String,
    val profile_picture: String
) : Serializable

