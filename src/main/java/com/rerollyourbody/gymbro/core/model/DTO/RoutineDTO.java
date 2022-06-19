package com.rerollyourbody.gymbro.core.model.DTO;

import com.rerollyourbody.gymbro.core.model.Exercise;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.Set;
import com.rerollyourbody.gymbro.core.model.WorkoutExercise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoutineDTO {
    private String id;
    private List<WorkoutExercise> workoutExercises;

    public static RoutineDTO of(Routine routine){
        return new RoutineDTO(
                routine.getRoutineId().toString(),
                routine.getWorkoutExercises()
        );
    }
}
