package com.wano.statesservice.service;

import com.wano.statesservice.model.State;
import com.wano.statesservice.repository.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepo stateRepo;

    public State getState(long id) {
        return stateRepo.getOne(id);
    }

    public State getStateByName(String name) {
        return stateRepo.findByName(name);
    }

    public State getStateByAbbreviation(String abbreviation) {
        return stateRepo.findByAbbreviation(abbreviation);
    }

    public List<State> getAllStates() {
        return new ArrayList<>(stateRepo.findAll());
    }

    public State addState(State state) {
        return stateRepo.save(state);
    }

    public State updateState(State state) {
        return addState(state);
    }

    public void deleteState(long id) {
        stateRepo.deleteById(id);
    }

    public void deleteState(State state) {}

}
