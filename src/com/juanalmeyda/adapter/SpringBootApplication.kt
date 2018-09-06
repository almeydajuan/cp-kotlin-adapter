package com.juanalmeyda.adapter

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class SpringBootApplication {

    fun main(args: Array<String>) {
        SpringApplication.run(SpringBootApplication::class.java, *args)
    }
}