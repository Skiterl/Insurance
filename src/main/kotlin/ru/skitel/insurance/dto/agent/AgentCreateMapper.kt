package ru.skitel.insurance.dto.agent

import org.springframework.stereotype.Component
import ru.skitel.insurance.model.Agent
import ru.skitel.insurance.utils.mapper.Mapper
import java.util.*

@Component
class AgentCreateMapper: Mapper<AgentCreateDto, Agent> {
    override fun toDto(entity: Agent): AgentCreateDto {
        return AgentCreateDto(
            firstName = entity.firstName,
            lastName = entity.lastName,
            email = entity.email,
            city = entity.city,
            phone = entity.phone
        )
    }

    override fun toEntity(dto: AgentCreateDto): Agent {
        return Agent(
            agentId = UUID.randomUUID(),
            firstName = dto.firstName,
            lastName = dto.lastName,
            email = dto.email,
            city = dto.city,
            phone = dto.phone
        )
    }

}