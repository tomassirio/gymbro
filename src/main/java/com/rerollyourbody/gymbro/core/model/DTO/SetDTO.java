package com.rerollyourbody.gymbro.core.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetDTO {

    private Integer repetitions;
    private Float weight;

    public static SetDTO of(SetDTO setDTO){
        return new SetDTO(
                setDTO.getRepetitions(),
                setDTO.getWeight()
        );
    }
}
