package com.rerollyourbody.gymbro.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Exercise {

    private String name;
    private BodyFocus bodyFocus;
}
