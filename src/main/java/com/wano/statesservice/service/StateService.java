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
        return null;
    }

    public State getStateByAbbreviation(String abbreviation) {
        return null;
    }

    public List<State> getAllStates() {
        List<State> states = new ArrayList<>();
        stateRepo.findAll().forEach(states::add);
        return states;
    }

    public State addState(State state) {
        return null;
    }

    public State updateState(State state) {
        return null;
    }

    public void deleteState(long id) {}

    public void deleteState(State state) {}

}
