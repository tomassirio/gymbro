package com.rerollyourbody.gymbro.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Exercise {

    private String name;
    private BodyFocus bodyFocus;
}
