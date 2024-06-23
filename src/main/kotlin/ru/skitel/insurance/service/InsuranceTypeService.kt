package ru.skitel.insurance.service

import ru.skitel.insurance.dto.insurancetype.InsuranceTypeCreateDto
import ru.skitel.insurance.model.InsuranceType
import java.util.*

interface InsuranceTypeService {
    fun findAll(): Iterable<InsuranceType>
    fun findById(id: UUID): InsuranceType
    fun save(insuranceTypeDto: InsuranceTypeCreateDto): InsuranceType
}