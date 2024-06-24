package ru.skitel.insurance.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.skitel.insurance.dto.contract.ContractCreateDto
import ru.skitel.insurance.model.Contract
import ru.skitel.insurance.service.ContractService
import ru.skitel.insurance.utils.response.Response
import java.util.*

@RestController
@RequestMapping("/contracts")
class ContractController(
    @Autowired
    private val contractService: ContractService
) {
    @GetMapping("/")
    fun getAllUsers() : Iterable<Contract> = contractService.findAll()

    @GetMapping("/{id}")
    fun getContractById(@PathVariable id: UUID) : Contract = contractService.findById(id)

    @GetMapping("/agent/{id}")
    fun getAllContractsByAgentId(@PathVariable id: UUID) : Iterable<Contract> = contractService.findByAgentId(id)

    @PostMapping("/save/")
    fun saveContract(@RequestBody contractDto: ContractCreateDto) : Contract = contractService.save(contractDto)

    @DeleteMapping("/delete/{id}")
    fun deleteContract(@PathVariable id: UUID) : ResponseEntity<Response> = contractService.delete(id)
}