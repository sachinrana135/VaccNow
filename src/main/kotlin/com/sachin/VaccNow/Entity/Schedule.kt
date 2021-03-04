package com.sachin.VaccNow.Entity

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "schedule")
data class Schedule(
        @Id
        @GeneratedValue
        val id: Long = 0,
        @Column(nullable = false)
        val email: String,
        @Column(name="`from`", nullable = false)
        val from: Timestamp,
        @Column(name="`to`",nullable = false)
        val to: Timestamp,
        @OneToOne(cascade = [CascadeType.DETACH])
        @JoinColumn(name = "branch_id", referencedColumnName = "id")
        val branch: Branch,
        @OneToOne(cascade = [CascadeType.DETACH])
        @JoinColumn(name = "vaccine_id", referencedColumnName = "id")
        val vaccine: Vaccine,
        @Column(nullable = false)
        val paymentType: String,
        @Column(nullable = false)
        val status: String,
        @Column(name = "date_created", nullable = false)
        val dateCreated: Timestamp,
        @Column(name = "date_modified", nullable = false)
        val dateModified: Timestamp
)