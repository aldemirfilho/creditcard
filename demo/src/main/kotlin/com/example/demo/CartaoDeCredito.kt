package com.example.demo

import jakarta.persistence.*

@Entity(name = "cartoes")
data class CartaoDeCredito(
    @Id @GeneratedValue
    var id: Long? = null,
    var numeroDoCartao: String = "",
    var limiteDeCredito: Float? = null,
    @Column(name = "cliente_id") // Coluna para representar o ID da Fatura relacionada
    var titular: Long? = null,

    @Column(name = "fatura_id") // Coluna para representar o ID da Fatura relacionada
    var faturaId: Long? = null, // Agora é um tipo primitivo (ID da Fatura)

    var histCompra: List<Long> = mutableListOf(), //lista dos Ids das faturas
    var status: String = ""
)
