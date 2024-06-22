package ru.skitel.insurance.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.skitel.insurance.dto.agent.AgentCreateDto
import ru.skitel.insurance.model.Agent
import ru.skitel.insurance.repository.AgentRepository
import java.util.*

interface AgentService {

    fun findAll(): Iterable<Agent>
    fun findById(id: UUID): Agent
    fun save(agent: AgentCreateDto): Agent
}