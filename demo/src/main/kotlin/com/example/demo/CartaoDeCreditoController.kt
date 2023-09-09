package com.example.demo

import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cartoes")
class CartaoDeCreditoController(private val repository: CartaoDeCreditoRepository) {

    @PostMapping
    fun create(@RequestBody cartaoDeCredito: CartaoDeCredito): CartaoDeCredito = repository.save(cartaoDeCredito)

    @GetMapping
    fun getAll(): List<CartaoDeCredito> = repository.findAll()

    @GetMapping("/{id}")
    fun getbyId(@PathVariable id: Long): ResponseEntity<CartaoDeCredito> =
        repository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody cartaoDeCredito: CartaoDeCredito): ResponseEntity<CartaoDeCredito> =
        repository.findById(id).map {
            val accountToUpdate = it.copy(
                numeroDoCartao = cartaoDeCredito.numeroDoCartao,
                titular = cartaoDeCredito.titular,
                limiteDeCredito = cartaoDeCredito.limiteDeCredito,
                faturaId = cartaoDeCredito.faturaId,
                histCompra = cartaoDeCredito.histCompra,
                status = cartaoDeCredito.status
            )
            ResponseEntity.ok(repository.save(accountToUpdate))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> =
        repository.findById(id).map {
            repository.delete(it)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

}