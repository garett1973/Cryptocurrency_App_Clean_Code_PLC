package net.virgis.tutorials.cryptocurrencyapp.presentation.coin_list

import net.virgis.tutorials.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
