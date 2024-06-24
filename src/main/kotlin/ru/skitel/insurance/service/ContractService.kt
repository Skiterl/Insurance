package ru.skitel.insurance.service

import org.springframework.http.ResponseEntity
import ru.skitel.insurance.dto.contract.ContractCreateDto
import ru.skitel.insurance.model.Contract
import ru.skitel.insurance.utils.response.Response
import java.util.*

interface ContractService {
    fun findAll(): Iterable<Contract>
    fun findById(id: UUID): Contract
    fun findByAgentId(id: UUID): Iterable<Contract>
    fun save(contractDto: ContractCreateDto): Contract
    fun delete(id: UUID): ResponseEntity<Response>
}