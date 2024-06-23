package ru.skitel.insurance.exception

data class ApplicationError(
    val statusCode: Int?,
    val message: String?)