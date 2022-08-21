package com.rerollyourbody.gymbro.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity{
    private String name;
    private String lastName;
    private String email;
}
