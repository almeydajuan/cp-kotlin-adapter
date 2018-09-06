package com.juanalmeyda.adapter.search

import com.goeuro.coverage.goeuroconnect.model.v03.Combination
import org.springframework.util.CollectionUtils

class SolutionCombiner() {

    fun combine(solutions : List<SolutionWithOffers>) : List<Combination> {
        return solutions
                .filter { solution -> !CollectionUtils.isEmpty(solution.offers) }
                .map { solution -> Combination().apply  {
                    outboundSolutionId = solution.solution.solutionId
                    offers = solution.offers }
                }
    }
}