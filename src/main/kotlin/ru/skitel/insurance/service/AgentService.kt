package ru.skitel.insurance.service

import org.springframework.http.ResponseEntity
import ru.skitel.insurance.dto.agent.AgentCreateDto
import ru.skitel.insurance.dto.agent.AgentUpdateDto
import ru.skitel.insurance.model.Agent
import ru.skitel.insurance.utils.response.Response
import java.util.*

interface AgentService {

    fun findAll(): Iterable<Agent>
    fun findById(id: UUID): Agent
    fun save(agentDto: AgentCreateDto): Agent
    fun update(id: UUID, agentDto: AgentUpdateDto) : Agent
    fun delete(id: UUID): ResponseEntity<Response>
}