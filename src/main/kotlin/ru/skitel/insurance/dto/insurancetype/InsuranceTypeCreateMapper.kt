package ru.skitel.insurance.dto.insurancetype

import org.springframework.stereotype.Component
import ru.skitel.insurance.model.InsuranceType
import ru.skitel.insurance.utils.mapper.Mapper
import java.util.*

@Component
class InsuranceTypeCreateMapper : Mapper<InsuranceTypeCreateDto, InsuranceType> {
    override fun toDto(entity: InsuranceType): InsuranceTypeCreateDto {
        return InsuranceTypeCreateDto(
            name = entity.name,
            insuranceRate = entity.insuranceRate
        )
    }

    override fun toEntity(dto: InsuranceTypeCreateDto): InsuranceType {
        return InsuranceType(
            insuranceTypeId = UUID.randomUUID(),
            name = dto.name,
            insuranceRate = dto.insuranceRate
        )
    }
}