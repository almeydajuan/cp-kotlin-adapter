package com.juanalmeyda.adapter.search

import com.goeuro.comboios.client.ApiClient
import com.goeuro.comboios.client.model.Trip
import com.goeuro.coverage.goeuroconnect.model.v03.*

class SearchService(private val apiClient: ApiClient, val solutionCombiner : SolutionCombiner) : com.goeuro.coverage.goeuroconnect.sdk.service.SearchService {

    override fun getRoutes(): RoutesResponse {
        TODO("not implemented")
    }

    override fun search(searchRequest: SearchRequest): SearchResponse {
        val searchResponse = apiClient.search(searchRequest.transformToCurrentModel())
        return searchRequest.returnDate?.let { searchRoundtrip() } ?: searchOneWay(searchResponse, searchRequest.passengers)
    }

}

fun SearchService.searchOneWay(cpSearchResponse: com.goeuro.comboios.client.model.response.SearchResponse, passengers: Map<PassengerType, Int>): SearchResponse {
    val solutions = getSolutionsWithOffers(cpSearchResponse.outwardTrip)

    // instead of setter
    return SearchResponse().apply {
        currency =  CURRENCY
        combinations = solutionCombiner.combine(solutions)
    }
}

fun getSolutionsWithOffers(trips: List<Trip>): List<SolutionWithOffers> =
        trips
            .filter { it.isSaleableOnline }
            .map {
                SolutionWithOffers(
                        solution = Solution(),
                        offers = listOf(Offer())
                )
            }

fun searchRoundtrip() : SearchResponse {
    TODO("not implemented")
}