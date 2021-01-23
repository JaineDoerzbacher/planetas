package com.planets.features.services

import com.planets.features.dtos.PlanetDTO
import com.planets.features.entities.Planet
import com.planets.features.gateway.repositories.PlanetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlanetServiceImpl : PlanetService {
    @Autowired
    lateinit var planetRepository: PlanetRepository

    override fun create(planetDTO: PlanetDTO): PlanetDTO {

        var planeta = Planet(null, planetDTO.nome, planetDTO.solo, planetDTO.descricao)
        planeta = planetRepository.save(planeta)
        return PlanetDTO( planeta.nome, planeta.solo, planeta.descricao)
    }

    override fun getById(id: Long): PlanetDTO? {

        val planeta = planetRepository.findById(id).orElseGet(null)
        return PlanetDTO( planeta.nome, planeta.solo, planeta.descricao)
    }

    override fun delete(id: Long) {

        this.planetRepository.deleteById(id)

    }

    override fun getAll(): List<PlanetDTO> {
        val planetas = planetRepository.findAll().toList().sortedBy { it.nome }
        val lista = ArrayList<PlanetDTO>()

        for (planeta in planetas) {

            val planetDTO =
                PlanetDTO( planeta.nome, planeta.solo, planeta.descricao)
            lista.add(planetDTO)
        }

        return lista
    }

    override fun count(): Long = planetRepository.count()
}