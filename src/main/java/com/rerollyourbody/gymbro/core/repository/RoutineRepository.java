package com.rerollyourbody.gymbro.core.repository;

import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.Routine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoutineRepository extends MongoRepository<Routine, UUID> {
}
