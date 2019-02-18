package com.wano.statesservice.controller;

import com.wano.statesservice.model.State;
import com.wano.statesservice.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StateController {

    @Autowired
    private StateService stateService;

    public State getState(long id) {
        return stateService.getState(id);
    }

    public State getStateByName(String name) {
        return stateService.getStateByName(name);
    }

    public State getStateByAbbreviation(String abbreviation) {
        return stateService.getStateByAbbreviation(abbreviation);
    }

    public List<State> getAllStates() {
        return stateService.getAllStates();
    }

    public State addState(State state) {
        return null;
    }

    public State updateState(State state) {
        return null;
    }

    public void deleteStateById(long id) {}

    public void deleteState(State state) {}
}
