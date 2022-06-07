package com.rerollyourbody.gymbro.core.model.DTO;

import com.rerollyourbody.gymbro.core.model.Exercise;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutineDTO {
    private String id;
    private Map<Exercise, List<Set>> exercises;

    public static RoutineDTO of(Routine routine){
        return new RoutineDTO(
                routine.getRoutineId().toString(),
                routine.getExercises()
        );
    }
}
