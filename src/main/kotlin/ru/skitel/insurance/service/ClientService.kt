package ru.skitel.insurance.service

import org.springframework.http.ResponseEntity
import ru.skitel.insurance.dto.client.ClientCreateDto
import ru.skitel.insurance.dto.client.ClientUpdateDto
import ru.skitel.insurance.model.Client
import ru.skitel.insurance.utils.response.Response
import java.util.*


interface ClientService {
    fun findAll(): Iterable<Client>
    fun findById(id: UUID): Client
    fun save(clientDto: ClientCreateDto): Client
    fun update(id: UUID, clientDto: ClientUpdateDto) : Client
    fun delete(id: UUID): ResponseEntity<Response>
}