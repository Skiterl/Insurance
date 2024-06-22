package ru.skitel.insurance.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.skitel.insurance.model.Agent
import java.util.UUID

@Repository
interface AgentRepository: CrudRepository<Agent, UUID> {
}