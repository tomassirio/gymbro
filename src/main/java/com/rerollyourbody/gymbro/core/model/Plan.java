package com.rerollyourbody.gymbro.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Plan extends BaseEntity{
    @ManyToOne
    private User user;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Routine> routines;
    private Integer week;
    private Integer totalWeeks;

}

