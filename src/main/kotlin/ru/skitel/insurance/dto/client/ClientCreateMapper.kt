package ru.skitel.insurance.dto.client

import org.springframework.stereotype.Component
import ru.skitel.insurance.model.Client
import ru.skitel.insurance.utils.mapper.Mapper
import java.util.*

@Component
class ClientCreateMapper:Mapper<ClientCreateDto, Client> {
    override fun toDto(entity: Client): ClientCreateDto {
        return ClientCreateDto(
            firstName = entity.firstName,
            lastName = entity.lastName,
            email = entity.email,
            city = entity.city,
            phone = entity.phone
        )
    }

    override fun toEntity(dto: ClientCreateDto): Client {
        return Client(
            clientId = UUID.randomUUID(),
            firstName = dto.firstName,
            lastName = dto.lastName,
            email = dto.email,
            city = dto.city,
            phone = dto.phone
        )
    }
}