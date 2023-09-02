package com.example.demo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity(name = "cartoes")
data class CartaoDeCredito(
    @Id @GeneratedValue
    var id: Long? = null,
    var numeroDoCartao: String = "",
    var titular: String = "",
    var limiteDeCredito: Float? = null,
    var fatura: String = "",
    var histCompra: String = "",
    var status: String = ""
)
