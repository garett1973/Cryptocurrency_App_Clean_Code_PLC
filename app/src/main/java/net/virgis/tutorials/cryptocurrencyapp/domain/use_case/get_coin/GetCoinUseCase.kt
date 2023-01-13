package net.virgis.tutorials.cryptocurrencyapp.domain.use_case.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.virgis.tutorials.cryptocurrencyapp.common.Resource
import net.virgis.tutorials.cryptocurrencyapp.data.remote.dto.toCoin
import net.virgis.tutorials.cryptocurrencyapp.data.remote.dto.toCoinDetail
import net.virgis.tutorials.cryptocurrencyapp.domain.model.Coin
import net.virgis.tutorials.cryptocurrencyapp.domain.model.CoinDetail
import net.virgis.tutorials.cryptocurrencyapp.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Could not connect to external api"))
        }
    }
}