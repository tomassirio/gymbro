package com.rerollyourbody.gymbro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GymbroApplication

fun main(args: Array<String>) {
	runApplication<GymbroApplication>(*args)
}
