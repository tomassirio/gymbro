package com.rerollyourbody.gymbro.model

import java.util.*

data class Routine(val id: UUID, val userId: UUID, val excercises: RoutinePlan)

typealias RoutinePlan = Map<Excercise, SeriesPlan>
typealias SeriesPlan = ArrayList<Serie>

@JvmInline
value class Serie(
    val repetitions: Int
)
