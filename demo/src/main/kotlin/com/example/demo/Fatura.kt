package com.example.demo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity(name = "faturas")
data class Fatura(
    @Id @GeneratedValue
    var id: Long? = null,
    var numeroDaFatura: String = "",
    var cartao: String = "",
    var status: String = "",
    var dataEmissao: String = "",
    var dataVencimento: String = "",
    var valorTotal: Float? = null,
    var itensFatura: List<String> = mutableListOf()
)
