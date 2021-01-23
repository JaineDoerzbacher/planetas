package com.planets.features.services

import com.planets.features.dtos.PlanetDTO
import org.springframework.stereotype.Service

@Service
interface PlanetService {

    fun create(planetDTO: PlanetDTO): PlanetDTO
    fun getById(id: Long): PlanetDTO?
    fun delete(id: Long)
    fun getAll(): List<PlanetDTO>
    fun count(): Long

}