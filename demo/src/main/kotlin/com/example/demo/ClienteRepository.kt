package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository : JpaRepository<Cliente, Long> {
}