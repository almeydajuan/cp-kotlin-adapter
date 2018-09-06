package com.juanalmeyda.adapter.search

import com.goeuro.coverage.goeuroconnect.model.v03.Combination
import org.springframework.util.CollectionUtils

class SolutionCombiner {

    fun combine(solutions : List<SolutionWithOffers>) : List<Combination> {
        return solutions
                .filter { it.offers.isNotEmpty() }
                .map { Combination().apply  {
                    outboundSolutionId = it.solution?.solutionId
                    offers = it.offers }
                }
    }
}