package com.rerollyourbody.gymbro.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class WorkoutExercise {

    private Exercise exercise;
    private List<Set> sets;
}
