package com.example.demo

import jakarta.persistence.*

@Entity(name = "faturas")
data class Fatura(
    @Id @GeneratedValue
    var id: Long? = null,
    var numeroDaFatura: String = "",

    @Column(name = "cartao_id") // Coluna para representar o ID do CartaoDeCredito relacionado
    var cartaoId: Long? = null, // Agora é um tipo primitivo (ID do CartaoDeCredito)

    var status: String = "",
    var dataEmissao: String = "",
    var dataVencimento: String = "",
    var valorTotal: Float? = null,
    var itensFatura: List<String> = mutableListOf()
)
