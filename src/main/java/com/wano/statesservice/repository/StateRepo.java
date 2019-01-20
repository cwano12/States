package com.wano.statesservice.repository;

import com.wano.statesservice.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepo extends CrudRepository<State, Long> {

}
