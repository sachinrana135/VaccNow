package com.sachin.vaccnow.entity

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "vaccine")
data class Vaccine(
        @Id
        @GeneratedValue
        val id: Long,
        @Column(nullable = false)
        val name: String,
        @Column(nullable = false)
        val cost: Double,
        @Column(name = "date_created", nullable = false)
        val dateCreated: Timestamp,
        @Column(name = "date_modified", nullable = false)
        val dateModified: Timestamp
)