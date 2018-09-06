package com.juanalmeyda.adapter.search

import com.goeuro.coverage.goeuroconnect.model.v03.SearchRequest

// constant at compile time
const val CURRENCY = "EUR"

// extend an external class
fun SearchRequest.transformSearchRequest(): com.goeuro.comboios.client.model.request.SearchRequest {
    // cannot be changed
    return com.goeuro.comboios.client.model.request.SearchRequest.builder()
            .departureStationCode(this.departureStationCode)
            .arrivalStationCode(this.arrivalStationCode)
            .travelDate(this.departureDate)
            .returnDate(this.returnDate)
            .searchType(1)
            .configID(1000)
            .build()
}