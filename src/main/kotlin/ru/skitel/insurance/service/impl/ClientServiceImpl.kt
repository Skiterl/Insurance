package ru.skitel.insurance.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.skitel.insurance.dto.client.ClientCreateDto
import ru.skitel.insurance.dto.client.ClientCreateMapper
import ru.skitel.insurance.dto.client.ClientUpdateDto
import ru.skitel.insurance.dto.client.ClientUpdateMapper
import ru.skitel.insurance.exception.ResourceAlreadyExistsException
import ru.skitel.insurance.exception.ResourceNotFoundException
import ru.skitel.insurance.model.Client
import ru.skitel.insurance.repository.ClientRepository
import ru.skitel.insurance.service.ClientService
import ru.skitel.insurance.utils.response.Response
import java.util.*

@Service
class ClientServiceImpl(
    @Autowired
    val clientRepository: ClientRepository,
    @Autowired
    val clientCreateMapper: ClientCreateMapper,
    @Autowired
    val clientUpdateMapper: ClientUpdateMapper
) : ClientService {
    override fun findAll(): Iterable<Client> = clientRepository.findAll()

    override fun findById(id: UUID): Client {
        return clientRepository.findById(id)
            .orElseThrow { throw ResourceNotFoundException("Client with id $id not found") }
    }

    override fun save(clientDto: ClientCreateDto): Client {
        val client = clientRepository.findByEmail(clientDto.email)
        if(!client.isEmpty) throw ResourceAlreadyExistsException("Client with email ${clientDto.email} already exists")
        return clientRepository.save(clientCreateMapper.toEntity(clientDto))
    }

    override fun update(id: UUID, clientDto: ClientUpdateDto): Client {
        val client = clientRepository.findById(id)
            .orElseThrow { throw ResourceNotFoundException("Client with id $id not found") }

        clientUpdateMapper.updateClientFromDto(client, clientDto)
        return clientRepository.save(client)
    }

    override fun delete(id: UUID): ResponseEntity<Response> {
        if(!clientRepository.existsById(id)) throw ResourceNotFoundException("Client with id $id not found")
        clientRepository.deleteById(id)

        return ResponseEntity(Response(HttpStatus.OK.value(), "Client with id $id was deleted"), HttpStatus.OK)
    }
}