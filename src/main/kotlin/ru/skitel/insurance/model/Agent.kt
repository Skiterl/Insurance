package ru.skitel.insurance.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Email
import java.util.UUID

@Entity
@Table(name = "agent")
data class Agent (
    @Id
    @Column(name = "agent_id", updatable = false, unique = true, nullable = false)
    val agentId: UUID,

    @Column(name = "first_name")
    val firstName: String?,

    @Column(name = "last_name")
    val lastName: String?,

    @Email
    @Column(unique = true, nullable = false)
    val email: String,

    val city: String?,
    val phone: String?
)