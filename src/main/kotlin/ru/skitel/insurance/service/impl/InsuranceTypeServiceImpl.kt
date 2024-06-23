package ru.skitel.insurance.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.skitel.insurance.dto.insurancetype.InsuranceTypeCreateDto
import ru.skitel.insurance.dto.insurancetype.InsuranceTypeCreateMapper
import ru.skitel.insurance.exception.ResourceNotFoundException
import ru.skitel.insurance.model.InsuranceType
import ru.skitel.insurance.repository.InsuranceTypeRepository
import ru.skitel.insurance.service.InsuranceTypeService
import java.util.*

@Service
class InsuranceTypeServiceImpl(
    @Autowired
    val insuranceTypeRepository: InsuranceTypeRepository,
    @Autowired
    val insuranceTypeCreateMapper: InsuranceTypeCreateMapper
) : InsuranceTypeService{
    override fun findAll(): Iterable<InsuranceType> = insuranceTypeRepository.findAll()

    override fun findById(id: UUID): InsuranceType {
        return insuranceTypeRepository.findById(id)
            .orElseThrow { throw ResourceNotFoundException("InsuranceType with id $id not found") }
    }

    override fun save(insuranceTypeDto: InsuranceTypeCreateDto): InsuranceType {
        return insuranceTypeRepository.save(insuranceTypeCreateMapper.toEntity(insuranceTypeDto))
    }
}