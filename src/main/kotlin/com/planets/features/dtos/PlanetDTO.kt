package com.planets.features.dtos

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class PlanetDTO(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val nome: String,
    val solo: String,
    val descricao: String

)
