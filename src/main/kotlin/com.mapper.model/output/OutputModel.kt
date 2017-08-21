package com.mapper.model.output

import java.math.BigDecimal
import java.time.LocalDate

data class OutputValuation(
        var reference: String? = null,
        var supplierCode: String? = null,
        var premium: String? = null,
        var property: OutputProperty? = null,
        var dateCreated: LocalDate? = null,
        var risks: List<OutputRisk>? = null,
        var buyer: OutputContact? = null,
        var seller: OutputContact? = null
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
        var valueInDollar: BigDecimal?,
        var currency: String?
)

data class OutputAddress(
        var fullAddress: String? = null,
        var country: String? = null
)

data class OutputContact(
        var name: String? = null,
        var role: String? = null
)
