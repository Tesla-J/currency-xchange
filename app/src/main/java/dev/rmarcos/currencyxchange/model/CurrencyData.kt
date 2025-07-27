package dev.rmarcos.currencyxchange.model

data class CurrencyData(
    val name: String,
    val code: String,
    val symbol: String,
){
    override fun toString() = "${code.uppercase()} — $name"
}