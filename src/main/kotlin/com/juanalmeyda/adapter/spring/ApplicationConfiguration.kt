package com.juanalmeyda.adapter.spring

import com.goeuro.comboios.client.ApiClient
import com.goeuro.comboios.client.config.ComboiosClientConfig
import com.juanalmeyda.adapter.search.SearchService
import com.juanalmeyda.adapter.search.SolutionCombiner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ApplicationConfiguration {

    @Bean
    open fun searchService(apiClient: ApiClient, solutionCombiner: SolutionCombiner) : SearchService {
        return SearchService(apiClient, solutionCombiner)
    }

    @Bean
    open fun solutionCombiner() : SolutionCombiner {
        return SolutionCombiner()
    }

    @Bean
    open fun apiClient(): ApiClient {
        return ApiClient(ComboiosClientConfig())
    }

}