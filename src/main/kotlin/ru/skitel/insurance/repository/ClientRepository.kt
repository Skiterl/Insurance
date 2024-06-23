package ru.skitel.insurance.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.skitel.insurance.model.Client
import java.util.*

@Repository
interface ClientRepository: CrudRepository<Client, UUID> {
    fun findByEmail(email: String): Optional<Client>
}