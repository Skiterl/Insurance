package ru.skitel.insurance.dto.client

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull

data class ClientCreateDto(
    val firstName: String?,
    val lastName: String?,
    @Email
    @NotNull
    val email: String,
    val city: String?,
    val phone: String?
)