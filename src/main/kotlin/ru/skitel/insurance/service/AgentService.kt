package ru.skitel.insurance.service

import ru.skitel.insurance.dto.agent.AgentCreateDto
import ru.skitel.insurance.model.Agent
import java.util.*

interface AgentService {

    fun findAll(): Iterable<Agent>
    fun findById(id: UUID): Agent
    fun save(agent: AgentCreateDto): Agent
}