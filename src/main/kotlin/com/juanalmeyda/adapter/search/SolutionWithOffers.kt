package com.juanalmeyda.adapter.search

import com.goeuro.coverage.goeuroconnect.model.v03.Offer
import com.goeuro.coverage.goeuroconnect.model.v03.Solution

data class SolutionWithOffers(val solution: Solution, val offers: List<Offer>)