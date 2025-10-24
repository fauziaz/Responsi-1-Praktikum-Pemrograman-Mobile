package com.example.responsi1mobileh1d023117.data.model

data class Team(
    val id: Int,
    val name: String,
    val coach: Coach,
    val squad: List<Player>
)

data class Coach(
    val name: String,
    val nationality: String,
    val dateOfBirth: String
)

data class Player(
    val name: String,
    val position: String,
    val nationality: String,
    val dateOfBirth: String
)