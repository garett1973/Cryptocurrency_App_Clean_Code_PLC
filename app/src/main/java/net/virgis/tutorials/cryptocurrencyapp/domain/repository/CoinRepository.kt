package net.virgis.tutorials.cryptocurrencyapp.domain.repository

import net.virgis.tutorials.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import net.virgis.tutorials.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}