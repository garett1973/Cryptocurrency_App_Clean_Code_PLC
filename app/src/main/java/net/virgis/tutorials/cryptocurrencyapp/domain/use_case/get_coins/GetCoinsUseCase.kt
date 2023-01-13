package net.virgis.tutorials.cryptocurrencyapp.domain.use_case.get_coins

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.virgis.tutorials.cryptocurrencyapp.common.Resource
import net.virgis.tutorials.cryptocurrencyapp.data.remote.dto.toCoin
import net.virgis.tutorials.cryptocurrencyapp.domain.model.Coin
import net.virgis.tutorials.cryptocurrencyapp.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map{ it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Could not connect to external api"))
        }
    }
}