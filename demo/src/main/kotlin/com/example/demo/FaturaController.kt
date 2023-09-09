package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/faturas")
class FaturaController(private val repository: FaturaRepository) {

    @PostMapping
    fun create(@RequestBody fatura: Fatura): Fatura = repository.save(fatura)

    @GetMapping
    fun getAll(): List<Fatura> = repository.findAll()

    @GetMapping("/{id}")
    fun getbyId(@PathVariable id: Long): ResponseEntity<Fatura> =
        repository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> =
        repository.findById(id).map {
            repository.delete(it)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

}