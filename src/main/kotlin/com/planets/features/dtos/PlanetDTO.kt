package com.planets.features.dtos

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class PlanetDTO(
    val nome: String,
    val solo: String,
    val descricao: String

)
