package net.virgis.tutorials.cryptocurrencyapp.data.repository

import net.virgis.tutorials.cryptocurrencyapp.data.remote.CoinPaprikaApi
import net.virgis.tutorials.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import net.virgis.tutorials.cryptocurrencyapp.data.remote.dto.CoinDto
import net.virgis.tutorials.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}