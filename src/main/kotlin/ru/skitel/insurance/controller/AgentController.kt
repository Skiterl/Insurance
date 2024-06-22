package ru.skitel.insurance.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.skitel.insurance.dto.agent.AgentCreateDto
import ru.skitel.insurance.model.Agent
import ru.skitel.insurance.service.AgentService
import java.util.UUID

@RestController
@RequestMapping("/agents")
class AgentController (
    @Autowired
    private val agentService: AgentService
){
    @GetMapping("/")
    fun getAllUsers() : Iterable<Agent> = agentService.findAll()

    @GetMapping("/{id}")
    fun getAgentById(@PathVariable id: UUID) : Agent = agentService.findById(id)

    @PostMapping("/save/")
    fun saveAgent(@RequestBody user: AgentCreateDto) : Agent = agentService.save(user)

}