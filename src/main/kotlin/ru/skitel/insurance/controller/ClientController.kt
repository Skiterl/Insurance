package ru.skitel.insurance.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.skitel.insurance.dto.client.ClientCreateDto
import ru.skitel.insurance.dto.client.ClientUpdateDto
import ru.skitel.insurance.model.Client
import ru.skitel.insurance.service.ClientService
import ru.skitel.insurance.utils.response.Response
import java.util.*

@RestController
@RequestMapping("/clients")
class ClientController (
    @Autowired
    private val clientService: ClientService
) {
    @GetMapping("/")
    fun getAllUsers() : Iterable<Client> = clientService.findAll()

    @GetMapping("/{id}")
    fun getClientById(@PathVariable id: UUID) : Client = clientService.findById(id)

    @PostMapping("/save/")
    fun saveClient(@RequestBody clientDto: ClientCreateDto) : Client = clientService.save(clientDto)

    @PutMapping("/update/{id}")
    fun updateClient(@PathVariable id: UUID, @RequestBody clientDto: ClientUpdateDto) : Client = clientService.update(id, clientDto)

    @DeleteMapping("/delete/{id}")
    fun deleteClient(@PathVariable id: UUID) : ResponseEntity<Response> = clientService.delete(id)

}