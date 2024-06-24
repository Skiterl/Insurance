package ru.skitel.insurance.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.skitel.insurance.dto.contract.ContractCreateDto
import ru.skitel.insurance.exception.ResourceNotFoundException
import ru.skitel.insurance.model.Contract
import ru.skitel.insurance.repository.AgentRepository
import ru.skitel.insurance.repository.ClientRepository
import ru.skitel.insurance.repository.ContractRepository
import ru.skitel.insurance.repository.InsuranceTypeRepository
import ru.skitel.insurance.service.ContractService
import ru.skitel.insurance.utils.response.Response
import java.util.*

@Service
class ContractServiceImpl(
    @Autowired
    val contractRepository: ContractRepository,
    @Autowired
    val agentRepository: AgentRepository,
    @Autowired
    val insuranceTypeRepository: InsuranceTypeRepository,
    @Autowired
    val clientRepository: ClientRepository
) : ContractService {
    override fun findAll(): Iterable<Contract> = contractRepository.findAll()

    override fun findById(id: UUID): Contract {
        return contractRepository.findById(id)
            .orElseThrow { throw ResourceNotFoundException("Contract with id $id not found") }
    }

    override fun findByAgentId(id: UUID): Iterable<Contract> {
        agentRepository.findById(id)
            .orElseThrow { throw ResourceNotFoundException("Agent with id $id not found") }

        return contractRepository.findByAgentIdOrderByConclusionDate(id)
    }

    override fun save(contractDto: ContractCreateDto): Contract {
        return contractRepository.save(createContractByDto(contractDto))
    }

    override fun delete(id: UUID): ResponseEntity<Response> {
        if(!contractRepository.existsById(id)) throw ResourceNotFoundException("Contract with id $id not found")
        contractRepository.deleteById(id)

        return ResponseEntity(Response(HttpStatus.OK.value(), "Contract with id $id was deleted"), HttpStatus.OK)
    }

    private fun createContractByDto(dto: ContractCreateDto) : Contract{
        val agent = agentRepository.findById(dto.agentId)
            .orElseThrow { throw ResourceNotFoundException("Agent with id ${dto.agentId} not found") }
        val client = clientRepository.findById(dto.clientId)
            .orElseThrow { throw ResourceNotFoundException("Client with id ${dto.clientId} not found") }
        val insuranceType = insuranceTypeRepository.findById(dto.insuranceTypeId)
            .orElseThrow { throw ResourceNotFoundException("Insurance Type with id ${dto.insuranceTypeId} not found") }

        return Contract(
            contractId = UUID.randomUUID(),
            conclusionDate = Date(),
            insuranceSum = insuranceType.insuranceRate * dto.sumWithoutInsurance / 100 + dto.sumWithoutInsurance,
            agent = agent,
            client = client,
            insuranceType = insuranceType
        )
    }
}