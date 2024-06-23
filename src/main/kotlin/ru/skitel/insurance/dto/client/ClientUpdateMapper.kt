package ru.skitel.insurance.dto.client

import org.springframework.stereotype.Component
import ru.skitel.insurance.model.Client
import ru.skitel.insurance.utils.mapper.Mapper
import java.util.*

@Component
class ClientUpdateMapper:Mapper<ClientUpdateDto, Client> {
    override fun toDto(entity: Client): ClientUpdateDto {
        return ClientUpdateDto(
            firstName = entity.firstName,
            lastName = entity.lastName,
            city = entity.city,
            phone = entity.phone
        )
    }

    override fun toEntity(dto: ClientUpdateDto): Client {
        return Client(
            clientId = UUID.randomUUID(),
            firstName = dto.firstName,
            lastName = dto.lastName,
            email = "",
            city = dto.city,
            phone = dto.phone
        )
    }

    fun updateClientFromDto(client: Client, clientDto: ClientUpdateDto){
        client.firstName = clientDto.firstName
        client.lastName = clientDto.lastName
        client.city = clientDto.city
        client.phone = clientDto.phone
    }
}