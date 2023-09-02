package com.example.demo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity(name = "accounts")
data class Account(
    @Id @GeneratedValue
    var id: Long? = null,
    var name: String,
    var document: String,
    var phone: String
){
    // Construtor padrão sem argumentos
    constructor() : this(0, "", "", "")
}