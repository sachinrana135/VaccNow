package com.sachin.vaccnow.entity

import java.sql.Timestamp
import javax.persistence.*


@Entity
@Table(name = "branch_vaccine")
data class BranchVaccine(
        @Id
        @GeneratedValue
        val id: Long,
        @OneToOne(cascade = [CascadeType.DETACH])
        @JoinColumn(name = "branch_id", referencedColumnName = "id")
        val branch: Branch,
        @OneToOne(cascade = [CascadeType.DETACH])
        @JoinColumn(name = "vaccine_id", referencedColumnName = "id")
        val vaccine: Vaccine,
        var count: Long,
        @Column(name = "date_created", nullable = false)
        val dateCreated: Timestamp,
        @Column(name = "date_modified", nullable = false)
        val dateModified: Timestamp
)