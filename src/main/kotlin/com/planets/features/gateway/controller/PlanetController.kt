package com.planets.features.gateway.controller

import com.planets.features.dtos.PlanetDTO
import com.planets.features.services.PlanetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/planetas"])
class PlanetController {

    @Autowired
    lateinit var planetService: PlanetService


    @PostMapping()
    fun create(@RequestBody planetDTO: PlanetDTO): ResponseEntity<Any> {

        val registrarPlaneta = this.planetService.create(planetDTO)

        return ResponseEntity(registrarPlaneta, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Any> {
        var planeta = this.planetService.getById(id)

        if (planeta != null)
            return ResponseEntity(planeta, HttpStatus.OK)
        else return ResponseEntity(
            HttpStatus.NOT_FOUND
        )
    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {

        var status = HttpStatus.NOT_FOUND
        if (this.planetService.getById(id) != null) {
            status = HttpStatus.ACCEPTED
            this.planetService.delete(id)

        }
        return ResponseEntity(Unit, status)
    }

    @GetMapping()
    fun getAll(): ResponseEntity<List<PlanetDTO>> {

        val list = this.planetService.getAll()
        val status = if (list.size == 0) HttpStatus.NOT_FOUND else HttpStatus.OK

        return ResponseEntity(list, status)
    }

    @GetMapping("/count")
    fun count(): ResponseEntity<Map<String, Long>> =
        ResponseEntity.ok().body(mapOf("count" to this.planetService.count()))
}