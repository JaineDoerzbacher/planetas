package com.planets.features.gateway.repositories

import com.planets.features.entities.Planet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PlanetRepository : JpaRepository<Planet, Long> {

    @Query("select p from Planet p where p.nome = :nome ")
    fun findByNome(@Param("nome") nome: String) : List<Planet>

}