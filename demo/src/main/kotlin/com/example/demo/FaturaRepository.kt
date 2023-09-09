package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository

interface FaturaRepository : JpaRepository<Fatura, Long> {
}