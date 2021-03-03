package com.sachin.VaccNow.Entity

import javax.persistence.*


@Entity
@Table(name = "branch")
data class Branch(
        @Id
        @GeneratedValue
        val id: Long,
        @Column(nullable = false)
        val name: String,
        @Column(nullable = false)
        val location: String,
        @Column(name = "date_created", nullable = false)
        val dateCreated: String,
        @Column(name = "date_modified", nullable = false)
        val dateModified: String
)