package com.planets.features.entities

import javax.persistence.*

@Entity
@Table(name = "PLANETS")
data class Planet(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val nome: String,
    val solo: String,
    val descricao: String

)
