package ru.skitel.insurance.dto.agent

import org.springframework.stereotype.Component
import ru.skitel.insurance.model.Agent
import ru.skitel.insurance.utils.mapper.Mapper
import java.util.*

@Component
class AgentUpdateMapper: Mapper<AgentUpdateDto, Agent> {
    override fun toDto(entity: Agent): AgentUpdateDto {
        return AgentUpdateDto(
            firstName = entity.firstName,
            lastName = entity.lastName,
            city = entity.city,
            phone = entity.phone
        )
    }

    override fun toEntity(dto: AgentUpdateDto): Agent {
        return Agent(
            agentId = UUID.randomUUID(),
            firstName = dto.firstName,
            lastName = dto.lastName,
            email = "",
            city = dto.city,
            phone = dto.phone
        )
    }

    fun updateAgentFromDto(agent: Agent, agentDto: AgentUpdateDto){
        agent.firstName = agentDto.firstName
        agent.lastName = agentDto.lastName
        agent.city = agentDto.city
        agent.phone = agentDto.phone
    }
}