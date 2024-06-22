package ru.skitel.insurance.model

import jakarta.persistence.*
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "contract")
data class Contract (
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    val contractId: UUID,

    val conclusionDate: Date,
    val insuranceSum: Double,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "insurance_type_id")
    val insuranceType: InsuranceType,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agent_id")
    val agent: Agent,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    val client: Client
)