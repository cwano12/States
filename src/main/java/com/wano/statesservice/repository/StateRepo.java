package com.wano.statesservice.repository;

import com.wano.statesservice.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepo extends JpaRepository<State, Long> {
    State findByName(String name);
    State findByAbbreviation(String abbreviation);
}
