package com.mapper.model.input

import java.math.BigDecimal
import java.time.LocalDateTime

data class Valuation(
        var reference: String? = null,
        var supplier: String? = null,
        var premium: Boolean? = null,
        var property: Property? = null,
        var dateCreated: LocalDateTime? = null,
        var risks: List<Risk>? = null,
        var contacts: List<Contact>? = null,
        var appointmentInstructions: String? = null,
        var appointmentDateTime: LocalDateTime? = null,
        var appointmentContactNumber: String? = null
)

data class Property(
        var propertyType: PropertyType? = null,
        var address: Address? = null,
        var estimates: List<Estimate>? = null
)

enum class PropertyType {
    APARTMENT,
    HOUSE,
    LAND
}

data class Address(
        var streetName: String? = null,
        var unitNumber: String? = null,
        var state: String? = null,
        var zipCode: String? = null,
        var country: Country? = null
)

enum class Country {
    AUS,
    NLD
}

data class Estimate(
        var source: String? = null,
        var amount: Amount? = null
)

data class Amount(
        var valueInCents: BigDecimal?,
        var currency: String? = null
)

data class Risk(
        var name: String?,
        var value: Int?
)

data class Contact(
        var name: String? = null,
        var role: String? = null
)
