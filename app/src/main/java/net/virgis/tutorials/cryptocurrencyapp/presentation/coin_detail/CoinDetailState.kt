package net.virgis.tutorials.cryptocurrencyapp.presentation.coin_detail


import net.virgis.tutorials.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
