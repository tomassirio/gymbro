package com.rerollyourbody.gymbro.core.model.DTO;

import com.rerollyourbody.gymbro.core.model.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetDTO {

    private Integer repetitions;
    private Float weight;

    public static SetDTO of(Set set){
        return new SetDTO(
                set.getRepetitions(),
                set.getWeight()
        );
    }
}
