package com.wano.statesservice;

import com.wano.statesservice.model.State;

import java.util.ArrayList;
import java.util.List;

public interface AbstractStateServiceTest {

    long TEST_ID = 1;
    String TEST_STATE_NAME = "Delaware";
    String TEST_STATE_ABBREVIATION = "DE";
    String UPDATED_POPULATION = "1,000,000";
    State DELAWARE = new State();
    State updatedState = new State();
    List<State> states = new ArrayList<>();

    void init();

    void destroy();

    void initializeMocks();

    default void initializeStates() {
        DELAWARE.setId(TEST_ID);
        DELAWARE.setName(TEST_STATE_NAME);
        DELAWARE.setAbbreviation(TEST_STATE_ABBREVIATION);
        DELAWARE.setAdmissionDate("December 7, 1787");
        DELAWARE.setCapital("Dover");
        DELAWARE.setPopulation("952,065");
        DELAWARE.setArea(1982);

        updatedState.setId(DELAWARE.getId());
        updatedState.setName(DELAWARE.getName());
        updatedState.setAbbreviation(DELAWARE.getAbbreviation());
        updatedState.setAdmissionDate(DELAWARE.getAdmissionDate());
        updatedState.setCapital(DELAWARE.getCapital());
        updatedState.setPopulation(UPDATED_POPULATION);
        updatedState.setArea(DELAWARE.getArea());

        states.add(DELAWARE);
        states.add(new State(2, "Pennsylvania", "PA", "December 12, 1787", "Harrisburg",
                "12,702,379", 46055));
        states.add(new State(3, "New Jersey", "NJ", "December 18, 1787", "Trenton",
                "8,414,350", 8729));
        states.add(new State(4, "Georgia", "GA", "January 2, 1788", "Atlanta",
                "10,214,860", 59411));
        states.add(new State(5, "Connecticut", "CT", "January 9, 1788", "Hartford",
                "3,588,184", 5567));
        states.add(new State(6, "Massachusetts", "MA", "February 6, 1788", "Boston",
                "6,349,097", 10555));
        states.add(new State(7, "Maryland", "MD", "April 28, 1788", "Annapolis",
                "6,052,177", 12407));
        states.add(new State(8, "South Carolina", "SC", "May 23, 1788", "Columbia",
                "5,084,127", 32030));
        states.add(new State(9, "New Hampshire", "NH", "June 21, 1788", "Concord",
                "1,342,795", 9349));
        states.add(new State(10, "Virginia", "VA", "June 25, 1788", "Richmond",
                "7,567,465", 42793));
    }
}
