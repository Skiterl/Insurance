package ru.skitel.insurance.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.skitel.insurance.dto.agent.AgentCreateDto
import ru.skitel.insurance.dto.agent.AgentCreateMapper
import ru.skitel.insurance.exception.ResourceNotFoundException
import ru.skitel.insurance.model.Agent
import ru.skitel.insurance.repository.AgentRepository
import ru.skitel.insurance.service.AgentService
import java.util.*


@Service
class AgentServiceImpl(
    @Autowired
    val agentRepository: AgentRepository,
    @Autowired
    val agentCreateMapper: AgentCreateMapper
): AgentService {
    override fun findAll(): Iterable<Agent> = agentRepository.findAll()

    override fun findById(id: UUID): Agent {
        return agentRepository.findById(id)
            .orElseThrow { throw ResourceNotFoundException("Product with id $id not found") }
    }

    override fun save(agent: AgentCreateDto): Agent{
        return agentRepository.save(agentCreateMapper.toEntity(agent))
    }
}