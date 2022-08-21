package com.rerollyourbody.gymbro.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Routine extends BaseEntity{

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ExerciseBlock> exercises;
}

