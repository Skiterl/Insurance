package ru.skitel.insurance.utils.mapper

data class ApplicationError(
    private var statusCode: Int?,
    private val message: String?)