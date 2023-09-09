package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<ItemCompra, Long> {
}