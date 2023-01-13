package net.virgis.tutorials.cryptocurrencyapp.domain.model

import net.virgis.tutorials.cryptocurrencyapp.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
