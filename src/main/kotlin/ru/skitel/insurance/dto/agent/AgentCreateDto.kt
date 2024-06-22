package ru.skitel.insurance.dto.agent

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull

data class AgentCreateDto(
    val firstName: String?,
    val lastName: String?,
    @Email
    @NotNull
    val email: String,
    val city: String?,
    val phone: String?
)
