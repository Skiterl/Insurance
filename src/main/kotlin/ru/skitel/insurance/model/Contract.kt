package ru.skitel.insurance.model

import jakarta.persistence.*
import jakarta.validation.constraints.PastOrPresent
import jakarta.validation.constraints.Positive
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "contract")
data class Contract (
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    val contractId: UUID,

    @PastOrPresent
    val conclusionDate: Date,

    @Positive
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