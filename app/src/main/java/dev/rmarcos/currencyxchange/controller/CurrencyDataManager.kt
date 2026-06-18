package dev.rmarcos.currencyxchange.controller

import dev.rmarcos.currencyxchange.model.CurrencyData
import java.util.Currency

// TODO make a history logic to retrieve last used currency
fun getLastCurrency() = CurrencyData(
    "Angolan Kwanza", "AOA", Currency.getInstance("AOA").symbol
)

fun getCurrencyList() = listOf(
    CurrencyData(
        "Angolan Kwanza",
        "AOA",
        Currency.getInstance("AOA").symbol
    ),
    CurrencyData(
        "Euro",
        "EUR",
        Currency.getInstance("EUR").symbol
    ),
    CurrencyData(
        "American Dollar",
        "USD",
        Currency.getInstance("USD").symbol
    )
)