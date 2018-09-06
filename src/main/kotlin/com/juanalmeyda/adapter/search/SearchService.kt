package com.juanalmeyda.adapter.search

import com.goeuro.comboios.client.ApiClient
import com.goeuro.comboios.client.model.Trip
import com.goeuro.coverage.goeuroconnect.model.v03.*

class SearchService(private val apiClient: ApiClient, val solutionCombiner : SolutionCombiner) : com.goeuro.coverage.goeuroconnect.sdk.service.SearchService {

    override fun getRoutes(): RoutesResponse {
        TODO("not implemented")
    }

    //override fun search(searchRequest: SearchRequest?): SearchResponse { -- null check
    override fun search(searchRequest: SearchRequest): SearchResponse {
        return searchOneWay(apiClient.search(searchRequest.transformSearchRequest()), searchRequest.passengers)
    }

}

fun SearchService.searchOneWay(cpSearchResponse: com.goeuro.comboios.client.model.response.SearchResponse, passengers: Map<PassengerType, Int>): SearchResponse {
    val solutions = getSolutionsWithOffers(cpSearchResponse.outwardTrip)

    // instead of setter
    return SearchResponse().apply {
        currency =  "EUR"
        combinations = solutionCombiner.combine(solutions)
    }
}

fun getSolutionsWithOffers(trips: List<Trip>): List<SolutionWithOffers> {
    return trips
            .filter { trip -> trip.isSaleableOnline }
            .map { trip -> SolutionWithOffers(Solution(), listOf(Offer())) }
}