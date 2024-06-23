package ru.skitel.insurance.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.skitel.insurance.model.InsuranceType
import java.util.UUID

@Repository
interface InsuranceTypeRepository: CrudRepository<InsuranceType, UUID> {
}