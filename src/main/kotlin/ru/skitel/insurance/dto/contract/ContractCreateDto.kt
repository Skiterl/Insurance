package ru.skitel.insurance.dto.contract

import java.util.*

class ContractCreateDto (
    val sumWithoutInsurance: Double,
    val insuranceTypeId: UUID,
    val agentId: UUID,
    val clientId: UUID
)