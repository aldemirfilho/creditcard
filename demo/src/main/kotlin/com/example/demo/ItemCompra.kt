package com.example.demo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity(name = "itens")
data class ItemCompra(
    @Id @GeneratedValue
    var id: Long? = null,
    var descricao: String = "",
    var valor: Float? = null,
)