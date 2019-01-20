package com.wano.statesservice.service;

import com.wano.statesservice.model.State;
import com.wano.statesservice.repository.StateRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StateServiceTest {

    @Mock
    private StateRepo mockStateRepo;

    @InjectMocks
    private StateService testStateService;
    private final long testId = 1;
    private State state;
    private List<State> states;

    @Before
    public void init() {
        initializeStates();
        initializeMocks();
    }

    private void initializeMocks() {
        when(mockStateRepo.getOne(anyLong())).thenReturn(state);
        when(mockStateRepo.findAll()).thenReturn(states);
    }

    private void initializeStates() {
        state = new State(testId, "Delaware", "DE", "December 7, 1787", "Dover",
                "952,065", 1982);

        states = new ArrayList<>();
        states.add(state);
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

    @Test
    public void testGettingASingleStateById() {
        State foundState = testStateService.getState(testId);
        assertNotNull(foundState);
        assertEquals(state, foundState);
    }

    @Test
    public void testGettingAllStates() {
        List<State> foundStates = testStateService.getAllStates();
        assertNotNull(foundStates);
        assertEquals(10, foundStates.size());
        assertEquals(states, foundStates);
    }
}
