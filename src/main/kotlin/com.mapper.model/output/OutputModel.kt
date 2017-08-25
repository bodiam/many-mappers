package com.mapper.model.output

import java.math.BigDecimal
import java.time.LocalDateTime

data class OutputValuation(
        var reference: String? = null,
        var supplierCode: String? = null,
        var premium: String? = null,
        var property: OutputProperty? = null,
        var dateCreated: String? = null,
        var risks: List<OutputRisk>? = null,
        var buyer: OutputContact? = null,
        var seller: OutputContact? = null,
        var appointment: OutputAppointment? = null
)

data class OutputRisk(
        var name: String? = null,
        var value: Int? = null
)

data class OutputProperty(
        var type: String? = null,
        var address: OutputAddress? = null,
        var estimates: List<OutputEstimate>? = null
)

data class OutputEstimate(
        var source: String? = null,
        var amount: OutputAmount? = null
)

data class OutputAmount(
        var valueInDollar: BigDecimal? = null,
        var currency: String? = null
)

data class OutputAddress(
        var fullAddress: String? = null,
        var country: String? = null
)

data class OutputContact(
        var name: String? = null,
        var role: String? = null
)

data class OutputAppointment(
        var instructions: String? = null,
        var dateTime: LocalDateTime? = null,
        var contactNumber: String? = null
)