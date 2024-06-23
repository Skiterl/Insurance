package ru.skitel.insurance.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.skitel.insurance.dto.agent.AgentCreateDto
import ru.skitel.insurance.dto.agent.AgentCreateMapper
import ru.skitel.insurance.dto.agent.AgentUpdateDto
import ru.skitel.insurance.dto.agent.AgentUpdateMapper
import ru.skitel.insurance.exception.ResourceAlreadyExistsException
import ru.skitel.insurance.exception.ResourceNotFoundException
import ru.skitel.insurance.model.Agent
import ru.skitel.insurance.repository.AgentRepository
import ru.skitel.insurance.service.AgentService
import ru.skitel.insurance.utils.response.Response
import java.util.*


@Service
class AgentServiceImpl(
    @Autowired
    val agentRepository: AgentRepository,
    @Autowired
    val agentCreateMapper: AgentCreateMapper,
    @Autowired
    val agentUpdateMapper: AgentUpdateMapper
): AgentService {
    override fun findAll(): Iterable<Agent> = agentRepository.findAll()

    override fun findById(id: UUID): Agent {
        return agentRepository.findById(id)
            .orElseThrow { throw ResourceNotFoundException("Agent with id $id not found") }
    }

    override fun save(agentDto: AgentCreateDto): Agent{
        val agent = agentRepository.findByEmail(agentDto.email)
        if(!agent.isEmpty) throw ResourceAlreadyExistsException("Agent with email ${agentDto.email} already exists")
        return agentRepository.save(agentCreateMapper.toEntity(agentDto))
    }

    override fun update(id: UUID, agentDto: AgentUpdateDto): Agent {
        val agent = agentRepository.findById(id)
            .orElseThrow { throw ResourceNotFoundException("Agent with id $id not found") }

        agentUpdateMapper.updateAgentFromDto(agent, agentDto)
        return agentRepository.save(agent)
    }

    override fun delete(id: UUID): ResponseEntity<Response> {
        if(!agentRepository.existsById(id)) throw ResourceNotFoundException("Agent with id $id not found")
        agentRepository.deleteById(id)

        return ResponseEntity(Response(HttpStatus.OK.value(), "Agent with id $id was deleted"), HttpStatus.OK)
    }
}