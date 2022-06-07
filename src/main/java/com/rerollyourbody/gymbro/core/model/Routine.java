package com.rerollyourbody.gymbro.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Routine {
    private UUID routineId;
    private Map<Exercise, List<Set>> exercises;

    public void addExercise(Exercise exercise) {
        this.exercises.put(exercise, new ArrayList<>());
    }

    public void removeExercise(Exercise exercise) {
        this.exercises.remove(exercise);
    }

    public void addSet(Exercise exercise, Set set) {
        if (this.exercises.containsKey(exercise)) {
            this.exercises.put(exercise, List.of(set));
        } else {
            List<Set> sets = this.exercises.get(exercise);
            sets.add(set);
            this.exercises.replace(exercise, sets);
        }
    }

    public void removeSet(Exercise exercise, Set set) {
        if (this.exercises.containsKey(exercise)) {
            List<Set> sets = this.exercises.get(exercise);
            sets.remove(set);
            this.exercises.replace(exercise, sets);
        }
    }
}

