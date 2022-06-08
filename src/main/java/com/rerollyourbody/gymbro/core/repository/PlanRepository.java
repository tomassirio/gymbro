package com.rerollyourbody.gymbro.core.repository;

import com.rerollyourbody.gymbro.core.model.Plan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlanRepository extends MongoRepository<Plan, UUID> {
}
