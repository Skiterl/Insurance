package ru.skitel.insurance.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.util.UUID

@Entity
@Table(name = "insurance_type")
data class InsuranceType(
    @Id
    @Column(name = "insurance_type_id", updatable = false, unique = true, nullable = false)
    val insuranceTypeId: UUID,

    @NotNull
    @Column(nullable = false)
    var name: String,

    @NotNull
    @Column(name = "insurance_rate", nullable = false)
    var insuranceRate: Double
)
