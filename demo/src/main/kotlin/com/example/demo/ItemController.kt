package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/items")
class ItemController(private val repository: ItemRepository) {

    @PostMapping
    fun create(@RequestBody itemCompra: ItemCompra): ItemCompra = repository.save(itemCompra)

    @GetMapping
    fun getAll(): List<ItemCompra> = repository.findAll()

    @GetMapping("/{id}")
    fun getbyId(@PathVariable id: Long): ResponseEntity<ItemCompra> =
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