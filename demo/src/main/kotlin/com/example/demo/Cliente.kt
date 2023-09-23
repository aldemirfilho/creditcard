package com.example.demo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity(name = "clientes")
data class Cliente(
    @Id @GeneratedValue
    var id: Long? = null,
    var nome: String = "",
    var CPF: String = "",
    var cartoes: List<String> = mutableListOf() //numero dos cartoes
)
