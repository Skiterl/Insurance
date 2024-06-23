package ru.skitel.insurance.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.skitel.insurance.dto.insurancetype.InsuranceTypeCreateDto
import ru.skitel.insurance.model.InsuranceType
import ru.skitel.insurance.service.InsuranceTypeService
import java.util.*

@RestController
@RequestMapping("insurance_types/")
class InsuranceTypeController(
    @Autowired
    private val insuranceTypeService: InsuranceTypeService
) {
    @GetMapping("/")
    fun getAllUsers() : Iterable<InsuranceType> = insuranceTypeService.findAll()

    @GetMapping("/{id}")
    fun getInsuranceTypeById(@PathVariable id: UUID) : InsuranceType = insuranceTypeService.findById(id)

    @PostMapping("/save/")
    fun saveInsuranceType(@RequestBody insuranceTypeDto: InsuranceTypeCreateDto) : InsuranceType = insuranceTypeService.save(insuranceTypeDto)
}