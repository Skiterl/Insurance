package ru.skitel.insurance.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.skitel.insurance.model.Contract
import java.util.UUID

@Repository
interface ContractRepository: CrudRepository<Contract, UUID> {
    @Query(value = "SELECT * FROM contract where contract.agent_id = ?1", nativeQuery = true)
    fun findByAgentIdOrderByConclusionDate(id: UUID):Iterable<Contract>
}