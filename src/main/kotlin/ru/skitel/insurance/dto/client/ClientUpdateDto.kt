package ru.skitel.insurance.dto.client

data class ClientUpdateDto(
    val firstName: String?,
    val lastName: String?,
    val city: String?,
    val phone: String?
)